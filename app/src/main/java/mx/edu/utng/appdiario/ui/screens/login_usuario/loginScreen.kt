package mx.edu.utng.appdiario.ui.screens.login_usuario


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import mx.edu.utng.appdiario.R
import mx.edu.utng.negv.appdiariopersonal.model.LoginRequest



@Composable  //fillMaxSize ocupa toda la pantalla
fun LoginScreen( // Recibe el ViewModel de seguridad
                navController: NavHostController//recive la navegacion de mi pantalla
) {
    ///hice una variable de tipo LoginViewModel clase que se encuentra en mi viewModel que almacena mi viewmodel y mi liveData
    /// ahora ya lo puedo indicar donde yo quiera que mi logica viva mas tiempo

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF5E6D3))
    ) {                                            //ojo SapoTruco
        Login(
            Modifier.align(Alignment.Center),
            navController = navController //navegador
        // tienes que pasar el aligment por que aunque estes dentro de un box no te lo detecta entonces tiene que estar dentro del parametro
        ) //contieneViewModel ya que esta etiqueta indica que se mantendra viva mi logica por mucho tiempo
    }
}

@Composable
/////se esta trabajando toda la estructura de mi pantalla
///login contiene el viewModel al hacer que mi email y mi password quiero que los pase para que vivan ya que ste login almacena todos los elementos de mi pantalla

fun Login(modifier: Modifier, navController:NavController) {  //colocar el parametro que pasaste

    ////Vals que contienen MI VIEWMODEL para que sobrevivan a rotaciones o cambios de estado Dark
    // 🔑 USAMOS ESTADOS LOCALES DE COMPOSE para los campos de texto
    var emailState by remember { mutableStateOf("") }
    var passwordState by remember { mutableStateOf("") }

    // Lógica para habilitar el botón (se simplifica)
    val loginEnable = emailState.isNotEmpty() && passwordState.isNotEmpty()

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 1.dp),
        horizontalAlignment = Alignment.CenterHorizontally,    ///////Align
        verticalArrangement = Arrangement.Center

    ) {

        Imagen(Modifier.padding(top = 10.dp))///1 imagen
        EmailField(emailState, { emailState = it })   ///textfiedlemail
        Spacer(modifier = Modifier.padding(10.dp))


        //el PasswordField
        PasswordField(passwordState) { passwordState = it }
        Spacer(modifier = Modifier.padding(13.dp))


        // 🔑 CONEXIÓN DEL BOTÓN: Llama al AuthViewModel
        LoginButton(loginEnable) {
            val request = LoginRequest(
                email = emailState,
                password = passwordState
            )
             // <--- ¡Esto inicia la secuencia de seguridad!
        }


        Spacer(modifier = Modifier.padding(8.dp))
        RegistrarseBotton(loginEnable = true) {navController.navigate("adminHome") }//boton registrarse nav

    }
}


@Composable
fun Imagen(modifier: Modifier) {

    Image(painter = painterResource(R.drawable.fondo), contentDescription = "imagen de fondo")

}


@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
////////////////////////////////////////////////////////////////////////////////////////////caja textfieldpassword
    TextField(
        modifier = Modifier
            .width(320.dp)
            .height(56.dp)
            .fillMaxWidth(),


        placeholder = {
            Text(
                text = "Password",
                color = Color(0xFF4B3621),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic // opcional, si quieres cursiva también
            )
        },

        value = password,
        onValueChange = { onTextFieldChanged(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,  //no permite los enter/no permite que el texto es mas largo que el ancjo del campo
        maxLines = 1,      //escribes en una sola linea infinita (mas flexible) si colocas 2 ahora 2 lineas .
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color(0xFF4B3621),
            unfocusedContainerColor = Color.White

        )
    )
}

////////////////////////////////Boton
@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() },

        modifier = Modifier

            .width(330.dp)
            .height(48.dp), colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,  //// :)antes backgroundColor
            contentColor = Color.White,    //   :)color del texto o ícono
            disabledContainerColor = Color(0xFFEB833D),  //  fondo cuando está desactivado
            disabledContentColor = Color.White    // texto cuando está desactivado

        ), enabled = loginEnable


    ) {
        Text(
            "Iniciar Secion",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun RegistrarseBotton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() },

        modifier = Modifier

            .width(330.dp)
            .height(48.dp), colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,  //// :)antes backgroundColor
            contentColor = Color.White,    //   :)color del texto o ícono
            disabledContainerColor = Color.Black,  // 🔥 fondo cuando está desactivado
            disabledContentColor = Color.White     // texto cuando está desactivado

        ), enabled = loginEnable


    ) {
        Text(
            "Registrarse",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

    }

}

////////////////////////////////////////////////////correo
@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {

////////////////////////////////////////////////////////////////////////////////////////////caja textfieldEmail

    TextField(
        modifier = Modifier
            .width(320.dp)
            .height(56.dp)
            .fillMaxWidth(),


        placeholder = {
            Text(
                text = "Email",
                color = Color(0xFF4B3621),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic // opcional, si quieres cursiva también
            )

        },
        value = email,
        onValueChange = { onTextFieldChanged(it) },   //eso(it) que se escribe lo guarda en mi variable email y lo recuerda //onValueChange es la pulsacion de mi teclado lo activa y por lo tanto hace lo que ya escribi
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,  //no permite los enter/no permite que el texto es mas largo que el ancjo del campo
        maxLines = 1,      //escribes en una sola linea infinita (mas flexible) si colocas 2 ahora 2 lineas .
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color(0xFF4B3621),
            unfocusedContainerColor = Color.White

        )


    )
}