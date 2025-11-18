package mx.edu.utng.appdiario.navigation.navegacion_global

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.edu.utng.appdiario.navigation.barra_navegacion_admin.NavegacionAdmin
import mx.edu.utng.appdiario.navigation.barra_navegacion_cliente.NavegacionCliente
import mx.edu.utng.appdiario.ui.screens.auth.login_usuario.LoginScreen
import mx.edu.utng.appdiario.ui.screens.administrador.dashboardAdministrador.AdminHome
import mx.edu.utng.appdiario.ui.screens.auth.registro_usuario.Registro
import mx.edu.utng.appdiario.ui.screens.administrador.gestionusuario.GestionUsuarios
import mx.edu.utng.appdiario.ui.screens.administrador.reportes_para_administrador.ReportesAdmin

object NavRoutes {
    //AUTH##################################
    const val LOGIN = "login"
    const val REGISTRO = "registro"

    //ADMIN################################
    const val ADMIN_HOME = "adminHome"
    const val USUARIOS = "usuarios"
    const val REPORTES = "reportes"
    const val DASHBOARD_ADMIN = "dashboard_admin"

    //CLIENTE##########################
    const val HOME_NORMAL = "homeNormal"
    const val BARRA_CLIENTE = "barraCliente"

    // NUEVAS PANTALLAS PARA DIARIOS
    const val DIARIO_TEXTO = "diario_texto"
    const val DIARIO_AUDIO = "diario_audio"
}

@Composable
fun NavegacionApp(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.LOGIN
    ) {
        // Pantalla de login
        composable(NavRoutes.LOGIN) { LoginScreen(navController = navController) }

        // Registro de usuario
        composable(NavRoutes.REGISTRO) { Registro(navController = navController) }

        // Dashboard del admin con barra inferior
        composable(NavRoutes.DASHBOARD_ADMIN) { NavegacionAdmin(navController = navController) }

        // Pantalla de administración específica
        composable(NavRoutes.ADMIN_HOME) { AdminHome(navController = navController) }

        // Pantalla Usuarios
        composable(NavRoutes.USUARIOS) { GestionUsuarios(navController = navController) }

        // Pantalla Reportes
        composable(NavRoutes.REPORTES) { ReportesAdmin(navController = navController) }

        // Pantalla casa Cliente (ya no se usa directamente, se accede a través de BARRA_CLIENTE)
        composable(NavRoutes.HOME_NORMAL) {
            // Redirigir a la barra de navegación del cliente
            navController.navigate(NavRoutes.BARRA_CLIENTE) {
                popUpTo(NavRoutes.BARRA_CLIENTE) { inclusive = true }
            }
        }

        // Navegación principal del cliente con barra inferior
        composable(NavRoutes.BARRA_CLIENTE) {
            NavegacionCliente(globalNavController = navController)
        }

        // NUEVAS PANTALLAS PARA DIARIOS (si necesitas acceso directo)
        composable(NavRoutes.DIARIO_TEXTO) {
            // Estas pantallas ahora se manejan dentro de NavegacionCliente
            // Pero si necesitas acceso directo desde otras partes, las defines aquí
            // DiarioTextoScreen(navController = navController)
            navController.navigate(NavRoutes.BARRA_CLIENTE)
        }

        composable(NavRoutes.DIARIO_AUDIO) {
            // DiarioAudioScreen(navController = navController)
            navController.navigate(NavRoutes.BARRA_CLIENTE)
        }
    }
}