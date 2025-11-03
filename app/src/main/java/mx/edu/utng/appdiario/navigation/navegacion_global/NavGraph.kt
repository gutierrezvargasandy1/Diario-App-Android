package mx.edu.utng.appdiario.navigation.navegacion_global

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.edu.utng.appdiario.navigation.barra_navegacion_admin.NavegacionAdmin
import mx.edu.utng.appdiario.ui.screens.dashboardAdministrador.AdminHome
import mx.edu.utng.appdiario.ui.screens.gestionusuario.GestionUsuarios
import mx.edu.utng.appdiario.ui.screens.login_usuario.LoginScreen
import mx.edu.utng.appdiario.ui.screens.registro_usuario.Registro
import mx.edu.utng.appdiario.ui.screens.reportes_para_administrador.ReportesAdmin

object NavRoutes {
    const val ADMIN_HOME = "adminHome"
    const val USUARIOS = "usuarios"
    const val REPORTES = "reportes"
    const val LOGIN = "login"
    const val DASHBOARD_ADMIN = "dashboard_admin"
    const val REGISTRO = "registro"
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
        composable(NavRoutes.DASHBOARD_ADMIN) {
            NavegacionAdmin() // ✅ Usa NavController interno solo para la barra inferior
        }

        // Pantalla de administración específica
        composable(NavRoutes.ADMIN_HOME) { AdminHome(navController = navController) }

        // Pantalla Usuarios
        composable(NavRoutes.USUARIOS) { GestionUsuarios(navController = navController) }

        // Pantalla Reportes
        composable(NavRoutes.REPORTES) { ReportesAdmin(navController = navController) }
    }
}
