package mx.edu.utng.appdiario.local.entity

import androidx.room.Embedded
import androidx.room.Relation
import mx.edu.utng.appdiario.local.entity.Nota
import mx.edu.utng.appdiario.local.entity.Tarjeta

data class TarjetaConNotas(
    @Embedded val tarjeta: Tarjeta,
    @Relation(
        parentColumn = "idTarje",
        entityColumn = "tarjetaId"
    )
    val notas: List<Nota>
)
