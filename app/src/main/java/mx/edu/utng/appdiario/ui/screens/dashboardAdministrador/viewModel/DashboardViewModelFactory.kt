package mx.edu.utng.appdiario.ui.screens.dashboardAdministrador.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mx.edu.utng.appdiario.local.database.AppDatabase
import mx.edu.utng.appdiario.ui.screens.dashboardAdministrador.Repository.DashboardRepository

class DashboardViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            val database = AppDatabase.getDatabase(context)
            val repository = DashboardRepository(
                database.usuarioDao(),
                database.tarjetaDao()
            )
            return DashboardViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}