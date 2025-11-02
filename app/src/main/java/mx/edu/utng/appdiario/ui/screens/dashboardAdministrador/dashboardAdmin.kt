package mx.edu.utng.appdiario.ui.screens.dashboardAdministrador

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable

fun AdminHome(navController: NavController) {
    var selectedTab by remember { mutableStateOf("Inicio") }

    Scaffold(
        topBar = { TopAdmin(navController = navController) },
        bottomBar = {
            BottomNavBar(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5E6D3))
                .padding(innerPadding)
        ) {

            Titulo()
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                when (selectedTab) {
                    "Inicio" -> {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            DashboardCard(
                                title = "Usuarios Registrados",
                                value = "8",
                                subtitle = "Usuarios Activos en la App"
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            DashboardCard(
                                title = "Sección Popular",
                                value = "Receta",
                                subtitle = "Más consultada"
                            )
                        }
                    }
                    "Usuarios" -> Text("Pantalla de Usuarios")
                    "Reportes" -> Text("Pantalla de Reportes")
                }
            }
        }
    }
}


// ✅ Barra superior
@Composable
fun TopAdmin(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(0xFF6D3B1A)),
        contentAlignment = Alignment.CenterEnd
    ) {
        Button(
            onClick = { /* aquí será logout */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD2A679)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Text("Cerrar Sesión", color = Color.Black)
        }
    }
}


// ✅ Título centrado
@Composable
fun Titulo() {
    Text(
        text = "¡Bienvenido Administrador!",
        color = Color(0xFF4E2A0E),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        textAlign = TextAlign.Center
    )
}


// ✅ Dashboard card
@Composable
fun DashboardCard(
    title: String,
    value: String,
    subtitle: String,
) {
    Box(modifier = Modifier.padding(16.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFD9A97C)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = title,
                    tint = Color(0xFF4E2A0E),
                    modifier = Modifier.size(40.dp)
                )
                Text(title, fontWeight = FontWeight.Bold, color = Color(0xFF4E2A0E))
                Text(
                    value,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4E2A0E)
                )
                Text(subtitle, color = Color(0xFF4E2A0E))
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B5A2B))
                ) {
                    Text("Ver Más", color = Color.White)
                }
            }
        }
    }
}


// ✅ BOTTOM NAVBAR YA FUERA DEL DashboardCard ✅
@Composable
fun BottomNavBar(
    selectedTab: String,
    onTabSelected: (String) -> Unit,
) {
    NavigationBar(
        containerColor = Color(0xFF6D3B1A),
        contentColor = Color.White
    ) {
        NavigationBarItem(
            selected = selectedTab == "Inicio",
            onClick = { onTabSelected("Inicio") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio", tint = Color.White) },
            label = { Text("Inicio", color = Color.White) }
        )
        NavigationBarItem(
            selected = selectedTab == "Usuarios",
            onClick = { onTabSelected("Usuarios") },
            icon = { Icon(Icons.Default.Person, contentDescription = "Usuarios", tint = Color.White) },
            label = { Text("Usuarios", color = Color.White) }
        )
        NavigationBarItem(
            selected = selectedTab == "Reportes",
            onClick = { onTabSelected("Reportes") },
            icon = { Icon(Icons.Default.Check, contentDescription = "Reportes", tint = Color.White) },
            label = { Text("Reportes", color = Color.White) }
        )
    }
}
