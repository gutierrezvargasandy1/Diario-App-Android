package mx.edu.utng.appdiario.ui.screens.cliente.perfilUsuario

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mx.edu.utng.appdiario.Repository.UsuarioRepository
import kotlin.jvm.java

class PerfilUsuarioVMFactory(
    private val repository: UsuarioRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PerfilUsuarioViewModel::class.java)) {
            return PerfilUsuarioViewModel(repository) as T
        }
        throw kotlin.IllegalArgumentException("ViewModel desconocido")
    }
}
