package mx.edu.utng.appdiario.navigation.barra_navegacion_admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*

import mx.edu.utng.appdiario.ui.screens.gestionusuario.GestionUsuarios
import mx.edu.utng.appdiario.ui.screens.reportes_para_administrador.ReportesAdmin

// 🔹 Pantalla principal con barra inferior
@Composable
fun NavegacionAdmin(navController: NavController) {

    val subNavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(subNavController) }
    ) { innerPadding ->
        NavHost(
            navController = subNavController,
            startDestination = "home",
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("usuarios") { UsuariosScreen(navController) }
            composable("reportes") { ReportesScreen(navController) }
        }
    }
}

// 🔹 Barra inferior
@Composable
fun BottomNavBar(navController: NavController) {

    val items = listOf(
        NavItem("home", "🏠", "Home"),
        NavItem("usuarios", "👥", "Usuarios"),
        NavItem("reportes", "📊", "Reportes")
    )

    NavigationBar(containerColor = Color(0xFF6D3B1A)) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Text(item.icon, fontSize = 22.sp) },
                label = { Text(item.label, color = Color.White) }
            )
        }
    }
}

data class NavItem(val route: String, val icon: String, val label: String)

// 🔹 Home con botón Cerrar Sesión
@Composable
fun HomeScreen(navController: NavController) {
    Column {


        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("login") {
                popUpTo(0) { inclusive = true }
            }
        }) {
            Text("Cerrar sesión")
        }
    }
}

// 🔹 Pantalla Usuarios
@Composable
fun UsuariosScreen(navController: NavController) {
    GestionUsuarios(navController = navController)
}

// 🔹 Pantalla Reportes
@Composable
fun ReportesScreen(navController: NavController) {
    ReportesAdmin(navController = navController)
}
