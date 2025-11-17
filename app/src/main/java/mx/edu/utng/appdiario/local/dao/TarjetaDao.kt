package mx.edu.utng.appdiario.local.dao

import androidx.room.*
import mx.edu.utng.appdiario.local.entity.Tarjeta
import mx.edu.utng.appdiario.local.entity.TarjetaConNotas

@Dao
interface TarjetaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(tarjeta: Tarjeta)

    @Update
    suspend fun actualizar(tarjeta: Tarjeta)

    @Delete
    suspend fun eliminar(tarjeta: Tarjeta)

    @Query("SELECT * FROM Tarjeta")
    suspend fun obtenerTodas(): List<Tarjeta>

    @Query("SELECT * FROM Tarjeta WHERE idTarje = :id")
    suspend fun obtenerPorId(id: Int): Tarjeta?

    // 🔥 Nuevo método: tarjetas de un usuario con sus notas
    @Transaction
    @Query("SELECT * FROM Tarjeta WHERE usuarioId = :usuarioId")
    suspend fun obtenerTarjetasConNotasPorUsuario(usuarioId: Int): List<TarjetaConNotas>

    @Query("SELECT * FROM Tarjeta WHERE usuarioId = :userId")
    suspend fun obtenerTarjetasPorUsuario(userId: Int): List<Tarjeta>
}
