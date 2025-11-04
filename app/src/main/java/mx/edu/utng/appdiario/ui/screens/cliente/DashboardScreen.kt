package mx.edu.utng.appdiario.ui.screens.cliente

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// Colores personalizados
val FondoGeneral = Color(0xFFF5E6D3)
val FondoPanelColor = Color(0xFFD69B6F)
val FondoBotonColor = Color(0xFFFFCC89)
val PanelCafeColor = Color(0xFF5D2600)

@Composable
fun DashboardScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(FondoGeneral)
    ) {
        Column(
            modifier = Modifier.Companion
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            HeaderPanel()
            Spacer(modifier = Modifier.Companion.height(16.dp))
            TargetasSection()
        }
        BottomNavigationBar(modifier = Modifier.Companion.align(Alignment.Companion.BottomCenter))
    }
}

@Composable
fun HeaderPanel() {
    Box(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .background(
                FondoPanelColor,
                shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
            )
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.Companion.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {
            Column {
                Text(
                    "Today",
                    fontWeight = FontWeight.Companion.Bold,
                    color = Color.Companion.DarkGray
                )
                Text("Domingo", color = Color.Companion.DarkGray)
            }

            Box(
                modifier = Modifier.Companion
                    .background(
                        PanelCafeColor,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(6.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Text(
                    "5 /Oct /25",
                    color = Color.Companion.White,
                    fontWeight = FontWeight.Companion.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun TargetasSection() {
    Column {
        Box(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .background(
                    PanelCafeColor,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                )
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Companion.Center
        ) {
            Text(
                text = "Targetas",
                color = Color.Companion.White,
                fontWeight = FontWeight.Companion.Bold
            )
        }

        Spacer(modifier = Modifier.Companion.height(12.dp))

        TargetaItem(
            icon = Icons.Default.Person,
            text = "Personal"
        )

        Spacer(modifier = Modifier.Companion.height(8.dp))

        TargetaItem(
            icon = Icons.Default.Favorite,
            text = "Recetas"
        )

        Spacer(modifier = Modifier.Companion.height(8.dp))

        TargetaItem(
            icon = Icons.Default.Create,
            text = "Actividades"
        )
    }
}

@Composable
fun TargetaItem(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .background(
                FondoBotonColor,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
            )
            .clickable { }
            .padding(12.dp),
        verticalAlignment = Alignment.Companion.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.Companion.CenterVertically) {
            Icon(icon, contentDescription = text, tint = PanelCafeColor)
            Spacer(modifier = Modifier.Companion.width(8.dp))
            Text(text, color = Color.Companion.Black, fontWeight = FontWeight.Companion.Medium)
        }
        Text(">", color = PanelCafeColor, fontWeight = FontWeight.Companion.Bold, fontSize = 18.sp)
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier.Companion) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(FondoPanelColor)
            .padding(vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier.Companion.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {
            Icon(Icons.Default.Home, contentDescription = "Inicio", tint = PanelCafeColor)
            Icon(Icons.Default.List, contentDescription = "Calendario", tint = PanelCafeColor)
            Icon(Icons.Default.Person, contentDescription = "Perfil", tint = PanelCafeColor)
        }
    }
}