package mx.edu.utng.appdiario.ui.screens.login_usuario

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


///del tipo viewModel por que queremos estar actualizando
// todo lo que hace nuestra pantalla lo que es el remember todo lo logico
class LoginViewModel: ViewModel() {

    //////////////////////////////CORREO

    /*VIEWMODEL
    Guarda y maneja los datos de la interfaz de usuario (UI).
    Se comunica con el modelo (base de datos, API, repositorios, etc.).
    Sobrevive a los cambios de configuración (por ejemplo, rotar la pantalla)
    */
    private val _email = MutableLiveData<String>()

    //*variable observable y mutable, que puede cambiar de valor y
    // notificar automáticamente a la interfaz cuando cambia.*/
    val email: LiveData<String> =
        _email  //LiveData :esto le esta diciendo que solo puedo configurar desde AQUI

    /////////////////////////////////PASSWORD
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    ///////////////////////////////////LOGINENABLE --mi boton
    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    ////////////////////////////// EVENTO DE NAVEGACIÓN para mi boton registrarse
    private val _navigateToRegister = MutableLiveData<Boolean>()
    val navigateToRegister: LiveData<Boolean> = _navigateToRegister

    ////////////////////////////////ONELOGINCHANGED(Actualizar login)
    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email)
        .matches()/////esto ya es un prosedimiento automatico que valida si mi email es un email osea que lusca asi nombre@dominio.com

    private fun isValidPassword(password: String): Boolean =
        password.length > 6  //si password tiene mas de 6 palabras
}