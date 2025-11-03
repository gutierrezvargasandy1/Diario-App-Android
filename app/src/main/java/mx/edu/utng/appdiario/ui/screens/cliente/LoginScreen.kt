package mx.edu.utng.appdiario.ui.screens.cliente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Colores personalizados
val BotonPrincipalColor = Color(0xFF6200EE)
val TextoBotonColor = Color.White
val FondoCampoColor = Color(0xFFFFCC89)
val PanelSuperiorColor = Color(0xFF5D2600) // Café oscuro

@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF5E6D3))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Panel café superior
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PanelSuperiorColor)
                    .padding(vertical = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Registro",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Contenido del formulario (tu login original)
            Login(Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////
@Composable
fun Login(modifier: Modifier) {

    Spacer(modifier = Modifier.height(8.dp))
    EmailCom()
    Spacer(modifier = Modifier.height(8.dp))
    NombreCom()
    Spacer(modifier = Modifier.height(8.dp))
    ApellidoCom()
    Spacer(modifier = Modifier.height(8.dp))
    FechaNacimientoCom()
    Spacer(modifier = Modifier.height(8.dp))
    PasswordCom()
    Spacer(modifier = Modifier.height(16.dp))
    BotonesRegistro()
    Spacer(modifier = Modifier.height(24.dp))
    SocialLogin()
}

@Composable
fun EmailCom() {
    CampoTexto(placeholder = "Enter Email")
}

@Composable
fun NombreCom() {
    CampoTexto(placeholder = "Nombre")
}

@Composable
fun ApellidoCom() {
    CampoTexto(placeholder = "Apellido")
}

@Composable
fun FechaNacimientoCom() {
    CampoTexto(placeholder = "Día de Nacimiento")
}

@Composable
fun PasswordCom() {
    CampoTexto(placeholder = "Contraseña", isPassword = true)
}

@Composable
fun CampoTexto(placeholder: String, isPassword: Boolean = false) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .background(FondoCampoColor, shape = RoundedCornerShape(8.dp)),
        placeholder = { Text(placeholder) },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = FondoCampoColor,
            unfocusedContainerColor = FondoCampoColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        )
    )
}

@Composable
fun BotonesRegistro() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = BotonPrincipalColor)
        ) {
            Text("Registrarse", color = TextoBotonColor)
        }
        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(contentColor = BotonPrincipalColor)
        ) {
            Text("Cancelar")
        }
    }
}

@Composable
fun SocialLogin() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("O regístrate con")
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = {}) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Facebook")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Email, contentDescription = "Google")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Share, contentDescription = "Twitter")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegistroPreview() {
    LoginScreen()
}



