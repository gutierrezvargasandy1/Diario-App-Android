package mx.edu.utng.appdiario.Repository


import mx.edu.utng.appdiario.local.dao.TarjetaDao
import mx.edu.utng.appdiario.local.entity.Tarjeta.Tarjeta

class TarjetaRepository(
    private val tarjetaDao: TarjetaDao
) {
    suspend fun insertarTarjeta(tarjeta: Tarjeta) {
        tarjetaDao.insertar(tarjeta)
    }

    suspend fun actualizarTarjeta(tarjeta: Tarjeta) {
        tarjetaDao.actualizar(tarjeta)
    }

    suspend fun eliminarTarjeta(tarjeta: Tarjeta) {
        tarjetaDao.eliminar(tarjeta)
    }

    suspend fun obtenerTodasLasTarjetas(): List<Tarjeta> {
        return tarjetaDao.obtenerTodas()
    }

    suspend fun obtenerTarjetaPorId(id: Int): Tarjeta? {
        return tarjetaDao.obtenerTodas().find { it.idTarjeta == id }
    }

    suspend fun obtenerTarjetasPorUsuario(usuarioId: Int): List<Tarjeta> {
        return tarjetaDao.obtenerPorUsuario(usuarioId)
    }

    suspend fun obtenerTarjetasPorTipo(tipo: String): List<Tarjeta> {
        return tarjetaDao.obtenerTodas().filter { it.tipo.name == tipo }
    }
}