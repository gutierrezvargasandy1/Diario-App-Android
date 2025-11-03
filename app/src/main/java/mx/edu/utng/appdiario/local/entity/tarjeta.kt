package mx.edu.utng.appdiario.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName="Tarjeta",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["idUsua"],
            childColumns = ["idTarje"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class Tarjeta (
    @PrimaryKey(autoGenerate = true)
        val idTarje: Int,   ///si quieres colocarlo nulo solo introduce [val titulo:tring?]
    val titulo: String,
    val texto:String,
    val tipo:TipoTarjeta,
    val fecha:String
)