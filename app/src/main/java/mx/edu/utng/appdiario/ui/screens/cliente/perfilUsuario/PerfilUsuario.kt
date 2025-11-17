package mx.edu.utng.appdiario.ui.screens.cliente.perfilUsuario

import androidx.navigation.NavHostController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import mx.edu.utng.appdiario.Repository.UsuarioRepository
import mx.edu.utng.appdiario.local.database.AppDatabase
import mx.edu.utng.appdiario.navigation.navegacion_global.NavRoutes
import mx.edu.utng.appdiario.ui.screens.auth.login_usuario.SessionManager

// Colores de referencia
val FondoGeneral = Color(0xFFF5E6D3)
val FondoPanelColor = Color(0xFFD69B6F)
val FondoBotonColor = Color(0xFFFFCC89)
val PanelCafeColor = Color(0xFF5D2600)

@Composable
fun PerfilUsuario(
    navController: NavHostController,
    showBottomBar: MutableState<Boolean>,
    globalNavController: NavHostController
) {
    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }

    // Obtener ID del usuario desde DataStore (login)
    val userId by sessionManager.userIdFlow.collectAsState(initial = null)

    val usuarioDao = AppDatabase.getDatabase(context).usuarioDao()
    val repository = UsuarioRepository(usuarioDao)
    val factory = PerfilUsuarioVMFactory(repository)
    val viewModel: PerfilUsuarioViewModel = viewModel(factory = factory)

    val usuario by viewModel.usuario.collectAsState()

    // ✅ Cargar cuando tengamos el ID guardado
    LaunchedEffect(userId) {
        if (userId != null) {
            viewModel.cargarUsuarioPorId(userId!!)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoGeneral)
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            // ---- Encabezado ----
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(FondoPanelColor, RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Perfil de Usuario",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = usuario?.nombre ?: "Cargando...",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ---- Información del usuario ----
            InfoItem(label = "Correo", value = usuario?.email ?: "Cargando...")
            InfoItem(label = "Usuario", value = usuario?.nombre ?: "Cargando...")

            Spacer(modifier = Modifier.height(40.dp))

            // ---- Botón Cerrar sesión ----
            val scope = rememberCoroutineScope()
            Button(
                onClick = {
                    scope.launch {
                        viewModel.cerrarSesion()
                    }
                    showBottomBar.value = false
                    globalNavController.navigate(NavRoutes.LOGIN) {
                        popUpTo(0)
                        launchSingleTop = true
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = PanelCafeColor),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Cerrar sesión",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun InfoItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(FondoBotonColor, RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontWeight = FontWeight.Medium)
        Text(text = value, fontWeight = FontWeight.Bold)
    }
}
