package mx.edu.utng.appdiario.ui.screens.dashboardAdministrador.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import mx.edu.utng.appdiario.ui.screens.dashboardAdministrador.Repository.DashboardRepository

class DashboardViewModel(
    private val repository: DashboardRepository
) : ViewModel() {

    private val _state = MutableStateFlow(DashboardState())
    val state: StateFlow<DashboardState> = _state.asStateFlow()

    init {
        loadDashboardData()
    }

    fun loadDashboardData() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val usuarios = repository.getCantidadUsuarios()
                val tarjetaPopular = repository.getTipoTarjetaMasUsado()

                _state.value = DashboardState(
                    cantidadUsuarios = usuarios,
                    tipoTarjetaMasUsado = tarjetaPopular?.name ?: "Sin datos",
                    isLoading = false
                )
            } catch (e: Exception) {
                _state.value = DashboardState(
                    isLoading = false,
                    error = "Error: ${e.message}"
                )
            }
        }
    }
}

data class DashboardState(
    val cantidadUsuarios: Int = 0,
    val tipoTarjetaMasUsado: String = "Cargando...",
    val isLoading: Boolean = false,
    val error: String? = null
)