package mx.edu.utng.appdiario.Repository

import mx.edu.utng.appdiario.local.dao.NotaDao
import mx.edu.utng.appdiario.local.entity.Nota

class NotaRepository(private val notaDao: NotaDao) {

    suspend fun insertar(nota: Nota) = notaDao.insertar(nota)

    suspend fun actualizar(nota: Nota) = notaDao.actualizar(nota)

    suspend fun eliminar(nota: Nota) = notaDao.eliminar(nota)

    suspend fun obtenerTodas(): List<Nota> = notaDao.obtenerTodas()

    suspend fun obtenerPorId(id: Int): Nota? = notaDao.obtenerPorId(id)

    suspend fun obtenerPorTarjeta(tarjetaId: Int): List<Nota> =
        notaDao.obtenerPorTarjeta(tarjetaId)
}
