package mx.edu.utng.appdiario.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val idUsua: Int=0,
    val nombre:String,
    val apellidoMa:String,
    val apellidoPa:String,
    val fechNaci:String,
    val email: String,
    val password:String,
    val tipo: TipoUsuario
)