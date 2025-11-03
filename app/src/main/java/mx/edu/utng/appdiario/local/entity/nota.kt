package mx.edu.utng.appdiario.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

//la ForajeKey van dentro del entity siempre
@Entity(
    //nombre de la tabla
    tableName = "Nota",
    //llave foranea
    foreignKeys =[
        ForeignKey(
        entity= Tarjeta::class, //tabla padre
            parentColumns = ["idTarje"],//columna en la [tabla padre]
            childColumns = ["idNota"],//columna en esta [tabla hija]
            onDelete = ForeignKey.CASCADE//borrar en cascada si se borra trajeta tambien notas de la tarjeta
        )
    ]

)

data class Nota (
    @PrimaryKey(autoGenerate = true)
    val idNota:Int,
    val titulo:String,
    val texto:String
)