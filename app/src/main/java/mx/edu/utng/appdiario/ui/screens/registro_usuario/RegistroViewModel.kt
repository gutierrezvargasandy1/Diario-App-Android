package mx.edu.utng.appdiario.ui.screens.registro_usuario

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import mx.edu.utng.appdiario.Repository.UsuarioRepository
import mx.edu.utng.appdiario.local.entity.TipoUsuario
import mx.edu.utng.appdiario.local.entity.Usuario

data class RegistroState(
    val nombre: String = "",
    val apellidoPaterno: String = "",
    val apellidoMaterno: String = "",
    val fechaNacimiento: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)

class RegistroViewModel(
    private val repository: UsuarioRepository
) : ViewModel() {

    private val _state = MutableStateFlow(RegistroState())
    val state: StateFlow<RegistroState> = _state.asStateFlow()

    fun onNombreChange(nombre: String) {

        _state.value = _state.value.copy(nombre = nombre)
    }

    fun onApellidoPaternoChange(apellido: String) {
        _state.value = _state.value.copy(apellidoPaterno = apellido)
    }

    fun onApellidoMaternoChange(apellido: String) {
        _state.value = _state.value.copy(apellidoMaterno = apellido)
    }

    fun onFechaNacimientoChange(fecha: String) {
        _state.value = _state.value.copy(fechaNacimiento = fecha)
    }

    fun onEmailChange(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    // Registrar nuevo usuario (POST)
    fun registrarUsuario() {
        viewModelScope.launch {
            try {
                _state.value = _state.value.copy(isLoading = true, error = null)

                // Validaciones básicas
                if (state.value.nombre.isBlank() || state.value.email.isBlank() || state.value.password.isBlank()) {
                    _state.value = _state.value.copy(
                        error = "Por favor completa todos los campos",
                        isLoading = false
                    )
                    return@launch
                }

                val usuario = Usuario(
                    nombre = state.value.nombre,
                    apellidoPa = state.value.apellidoPaterno,
                    apellidoMa = state.value.apellidoMaterno,
                    fechNaci = state.value.fechaNacimiento,
                    email = state.value.email,
                    password = state.value.password,
                    tipo = TipoUsuario.NORMAL
                )

                repository.insertarUsuario(usuario)
                _state.value = _state.value.copy(isLoading = false, isSuccess = true)
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = "Error al registrar usuario: ${e.message}"
                )
            }
        }
    }

    fun limpiarEstado() {
        _state.value = RegistroState()
    }
}