package mx.edu.utng.appdiario.navigation.barra_navegacion_cliente

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import mx.edu.utng.appdiario.navigation.navegacion_global.NavRoutes
import mx.edu.utng.appdiario.ui.screens.auth.login_usuario.LoginScreen
import mx.edu.utng.appdiario.ui.screens.cliente.calendario.Calendario
import mx.edu.utng.appdiario.ui.screens.cliente.creacionNota.creacionNotaActividad.CreacionNotaActividad
import mx.edu.utng.appdiario.ui.screens.cliente.creacionNota.creacionNotaPersonal.CreacionNotaPersonal
import mx.edu.utng.appdiario.ui.screens.cliente.creacionNota.creacionNotaReceta.CreacionNotaReceta
import mx.edu.utng.appdiario.ui.screens.cliente.dashBoardCliente.DashboardScreen
import mx.edu.utng.appdiario.ui.screens.cliente.notaTipo.notaTipoActividad.NotaTipoActividad
import mx.edu.utng.appdiario.ui.screens.cliente.notaTipo.notaTipoPersonal.NotaTipoPersonal
import mx.edu.utng.appdiario.ui.screens.cliente.notaTipo.notaTipoReceta.NotaTipoReceta
import mx.edu.utng.appdiario.ui.screens.cliente.perfilUsuario.PerfilUsuario

@Composable
fun NavegacionCliente(navController: NavController) {
    // ✅ Solo un NavController para toda la navegación
    val navController = rememberNavController()
    val showBottomBar = remember { mutableStateOf(true) }

    Scaffold(
        bottomBar = { if (showBottomBar.value) { BottomNavBar(navController) }}
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            //Pantalla login(cerrar secion)
            composable(NavRoutes.LOGIN){LoginScreen(navController)}
            // Pantallas de la barra inferior
            composable("home") { DashboardScreen(navController) }
            composable("calendario") { Calendario(navController) }
            composable("usuario") {  PerfilUsuario(navController, showBottomBar) }

            // Pantallas para crear Notas según su tipo
            composable(NavRoutes.CREACION_NOTA_PERSONAL) { CreacionNotaPersonal(navController) }
            composable(NavRoutes.CREACION_NOTA_RECETA) { CreacionNotaReceta(navController) }
            composable(NavRoutes.CREACION_NOTA_ACTIVIDAD) { CreacionNotaActividad(navController) }


            // Pantallas de notas
            composable(NavRoutes.NOTA_TIPO_PERSONAL) { NotaTipoPersonal(navController) }
            composable(NavRoutes.NOTA_TIPO_RECETA) { NotaTipoReceta(navController) }
            composable(NavRoutes.NOTA_TIPO_ACTIVIDAD) { NotaTipoActividad(navController) }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf(
        NavItem("home", "🏠", "Inicio"),
        NavItem("calendario", "📅", "Calendario"),
        NavItem("usuario", "👤", "Usuario")
    )

    NavigationBar(containerColor = Color(0xFF6D3B1A)) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(NavRoutes.HOME_NORMAL) {  // 🔹 aquí hacemos pop hasta el Home real
                            inclusive = false   // dejamos HOME_NORMAL en la pila
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Text(
                        text = item.icon,
                        fontSize = 22.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = Color(0xFF8D4E25)
                )
            )
        }
    }
}

data class NavItem(val route: String, val icon: String, val label: String)
