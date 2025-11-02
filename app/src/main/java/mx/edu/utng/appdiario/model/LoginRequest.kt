package mx.edu.utng.negv.appdiariopersonal.model
//crea tu clase que almacena tu login para la peticion POST de (data/network/apiService)
data class LoginRequest(
    val email: String,
    val password:String,
    val  deviceId:String?=null //opcional util para el servidor
)