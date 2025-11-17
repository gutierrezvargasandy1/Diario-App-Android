package mx.edu.utng.appdiario.ui.screens.cliente.perfilUsuario

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mx.edu.utng.appdiario.Repository.UsuarioRepository
import mx.edu.utng.appdiario.local.entity.Usuario

class PerfilUsuarioViewModel(
    private val repository: UsuarioRepository
) : ViewModel() {

    private val _usuario = MutableStateFlow<Usuario?>(null)
    val usuario: StateFlow<Usuario?> = _usuario

    fun cargarUsuarioPorId(id: Int) {
        viewModelScope.launch {
            val user = repository.obtenerUsuarioPorId(id)
            _usuario.value = user
        }
    }

    fun cerrarSesion() {
        // Aquí puedes borrar las preferencias del usuario
        // o manejar la lógica de logout si hace falta
        _usuario.value = null
    }
}