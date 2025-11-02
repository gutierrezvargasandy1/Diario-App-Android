package mx.edu.utng.appdiario.navigation.navegacion_global


import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.edu.utng.appdiario.navigation.barra_navegacion_admin.NavegacionAdmin
import mx.edu.utng.appdiario.ui.screens.dashboardAdministrador.AdminHome
import mx.edu.utng.appdiario.ui.screens.gestionusuario.GestionUsuarios
import mx.edu.utng.appdiario.ui.screens.login_usuario.LoginScreen
import mx.edu.utng.appdiario.ui.screens.registro_usuario.Registro
import mx.edu.utng.appdiario.ui.screens.reportes_para_administrador.ReportesAdmin


// <--- ¡Tu ViewModel de seguridad!


// Definiciones de Rutas (Añade una ruta de Splash)
object NavRoutes {
    const val ADMIN_HOME = "adminHome"
    const val USUARIOS = "usuarios"
    const val REPORTES = "reportes"
    const val LOGIN = "login"
    const val DASHBOARD_ADMIN = "dashboard_admin"

    const val REGISTRO = "registro"

}

@Composable
fun NavegacionApp() {

    val controlNav = rememberNavController()

    NavHost(
        navController = controlNav,
        startDestination = NavRoutes.LOGIN
    ) {

        // Pantalla principal admin
        composable(NavRoutes.ADMIN_HOME) {
            AdminHome(navController = controlNav)
        }
        //pantalla usuarios
        composable(NavRoutes.USUARIOS) {
            GestionUsuarios(navController = controlNav) // <- Luego aquí metes tu pantalla real
        }
        //pantalla reportes
        composable(NavRoutes.REPORTES) {
            ReportesAdmin(navController = controlNav) // <- Luego aquí tu UI real
        }

        // Pantalla de login
        composable(NavRoutes.LOGIN) {
            LoginScreen(navController = controlNav)
        }
        composable(NavRoutes.DASHBOARD_ADMIN) {
            NavegacionAdmin(navController = controlNav)  // 🔥 Aquí entra toda la barra inferior y sus pantallas internas
        }




        composable(NavRoutes.REGISTRO) {
            Registro(navController = controlNav)  // 🔥 Aquí entra toda la barra inferior y sus pantallas internas
        }

    }
}
