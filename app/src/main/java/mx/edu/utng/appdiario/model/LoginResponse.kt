package mx.edu.utng.appdiario.model

//la informacion que el servidor devuelve despues del login exitoso
data class LoginResponse(
    val token: String,
    val user: User
)