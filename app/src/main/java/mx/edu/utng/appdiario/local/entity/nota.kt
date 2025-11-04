package mx.edu.utng.appdiario.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Nota",
    foreignKeys = [
        ForeignKey(
            entity = Tarjeta::class,
            parentColumns = ["idTarje"],
            childColumns = ["tarjetaId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Nota(
    @PrimaryKey(autoGenerate = true)
    val idNota: Int,
    val tarjetaId: Int,
    val titulo: String,
    val texto: String
)
