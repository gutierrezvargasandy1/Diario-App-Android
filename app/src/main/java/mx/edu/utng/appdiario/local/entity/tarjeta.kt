package mx.edu.utng.appdiario.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Tarjeta",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["idUsua"],
            childColumns = ["usuarioId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Tarjeta(
    @PrimaryKey(autoGenerate = true)
    val idTarje: Int,
    val usuarioId: Int, // 👈 relación con Usuario
    val titulo: String,
    val texto: String,
    val tipo: TipoTarjeta,
    val fecha: String
)
