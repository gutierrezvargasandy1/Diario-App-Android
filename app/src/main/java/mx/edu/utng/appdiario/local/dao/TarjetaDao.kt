package mx.edu.utng.appdiario.local.dao

import androidx.room.*
import mx.edu.utng.appdiario.local.entity.Tarjeta.Tarjeta

@Dao
interface TarjetaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(tarjeta: Tarjeta)

    @Update
    suspend fun actualizar(tarjeta: Tarjeta)

    @Delete
    suspend fun eliminar(tarjeta: Tarjeta)

    @Query("SELECT * FROM tarjeta")
    suspend fun obtenerTodas(): List<Tarjeta>

    @Query("SELECT * FROM tarjeta WHERE idUsua = :usuarioId")
    suspend fun obtenerPorUsuario(usuarioId: Int): List<Tarjeta>
}