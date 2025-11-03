package mx.edu.utng.appdiario.local.dao

import androidx.room.*
import mx.edu.utng.appdiario.local.entity.Nota

@Dao
interface NotaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(nota: Nota)

    @Update
    suspend fun actualizar(nota: Nota)

    @Delete
    suspend fun eliminar(nota: Nota)

    @Query("SELECT * FROM Nota")
    suspend fun obtenerTodas(): List<Nota>

    @Query("SELECT * FROM Nota WHERE idNota = :id")
    suspend fun obtenerPorId(id: Int): Nota?

    @Query("SELECT * FROM Nota WHERE idNota = :tarjetaId")
    suspend fun obtenerPorTarjeta(tarjetaId: Int): List<Nota>
}
