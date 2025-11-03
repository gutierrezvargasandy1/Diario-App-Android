package mx.edu.utng.appdiario.ui.screens.dashboardAdministrador.Repository

import mx.edu.utng.appdiario.local.dao.TarjetaDao
import mx.edu.utng.appdiario.local.dao.UsuarioDao
import mx.edu.utng.appdiario.local.entity.TipoTarjeta

class DashboardRepository(
    private val usuarioDao: UsuarioDao,
    private val tarjetaDao: TarjetaDao
) {
    suspend fun getCantidadUsuarios(): Int {
        return try {
            usuarioDao.obtenerTodos().size
        } catch (e: Exception) {
            0
        }
    }

    suspend fun getTipoTarjetaMasUsado(): TipoTarjeta? {
        return try {
            val tarjetas = tarjetaDao.obtenerTodas()
            tarjetas.groupingBy { it.tipo }
                .eachCount()
                .maxByOrNull { it.value }?.key
        } catch (e: Exception) {
            null
        }
    }
}