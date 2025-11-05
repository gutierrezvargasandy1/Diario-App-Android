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
import mx.edu.utng.appdiario.ui.screens.cliente.calendario.Calendario
import mx.edu.utng.appdiario.ui.screens.cliente.creacionNota.creacionNotaActividad.CreacionNotaActividad
import mx.edu.utng.appdiario.ui.screens.cliente.creacionNota.creacionNotaPersonal.CreacionNotaPersonal
import mx.edu.utng.appdiario.ui.screens.cliente.creacionNota.creacionNotaReceta.CreacionNotaReceta
import mx.edu.utng.appdiario.ui.screens.cliente.dashBoardCliente.DashboardScreen
import mx.edu.utng.appdiario.ui.screens.cliente.notaTipo.notaTipoActividad.NotaTipoActividad
import mx.edu.utng.appdiario.ui.screens.cliente.notaTipo.notaTipoPersonal.NotaTipoPersonal
import mx.edu.utng.appdiario.ui.screens.cliente.notaTipo.notaTipoReceta.NotaTipoReceta

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
    const val BARRA_CLIENTE="barraCliente"
    const val CALENDARIO="calendario"


    //CREACION_NOTA################################
    const val CREACION_NOTA_ACTIVIDAD="nota_actividad"
    const val CREACION_NOTA_PERSONAL="nota_personal"
    const val CREACION_NOTA_RECETA="nota_receta"


    //TIPO_NOTA######################################
    const val NOTA_TIPO_ACTIVIDAD="nota_tipo_actividad"
    const val NOTA_TIPO_PERSONAL="nota_tipo_personal"
    const val NOTA_TIPO_RECETA="nota_tipo_receta"

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
        composable(NavRoutes.REPORTES) {ReportesAdmin(navController = navController) }

        // Pantalla casa Cliente
        composable(NavRoutes.HOME_NORMAL) {DashboardScreen(navController = navController)}

        // Pantalla casa Cliente
        composable(NavRoutes.CALENDARIO) {Calendario (navController = navController)}

        //Pantallas para crear Notas segun su tipo:

        //Actividad
        composable(NavRoutes.CREACION_NOTA_ACTIVIDAD) {CreacionNotaActividad(navController = navController ) }
        //Personal
        composable(NavRoutes.CREACION_NOTA_PERSONAL) { CreacionNotaPersonal(navController = navController ) }
        //Recetas
        composable(NavRoutes.CREACION_NOTA_RECETA) { CreacionNotaReceta(navController = navController ) }

        //Pantallas de notas segun el tipo de tarjeta:
        composable(NavRoutes.NOTA_TIPO_ACTIVIDAD) {NotaTipoActividad(navController = navController ) }
        //Personal
        composable(NavRoutes.NOTA_TIPO_PERSONAL) { NotaTipoPersonal(navController = navController ) }
        //Recetas
        composable(NavRoutes.NOTA_TIPO_RECETA) {NotaTipoReceta(navController = navController ) }
        composable(NavRoutes.BARRA_CLIENTE) {NavegacionCliente(navController = navController ) }









    }
}
