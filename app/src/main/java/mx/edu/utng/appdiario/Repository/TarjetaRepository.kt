package mx.edu.utng.appdiario.Repository

import mx.edu.utng.appdiario.local.dao.TarjetaDao
import mx.edu.utng.appdiario.local.entity.Tarjeta

class TarjetaRepository (private val tarjetaDao: TarjetaDao) {

    suspend fun insertar(tarjeta: Tarjeta) = tarjetaDao.insertar(tarjeta)

    suspend fun actualizar(tarjeta: Tarjeta) = tarjetaDao.actualizar(tarjeta)

    suspend fun eliminar(tarjeta: Tarjeta) = tarjetaDao.eliminar(tarjeta)

    suspend fun obtenerTodas(): List<Tarjeta> = tarjetaDao.obtenerTodas()

    suspend fun obtenerPorId(id: Int): Tarjeta? = tarjetaDao.obtenerPorId(id)


}