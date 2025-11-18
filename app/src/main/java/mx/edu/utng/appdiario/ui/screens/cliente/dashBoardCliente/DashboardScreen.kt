package mx.edu.utng.appdiario.ui.screens.cliente.dashBoardCliente

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
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
import mx.edu.utng.appdiario.navigation.navegacion_global.NavRoutes

val FondoGeneral = Color(0xFFF5E6D3)
val FondoPanelColor = Color(0xFFD69B6F)
val FondoBotonColor = Color(0xFFFFCC89)
val PanelCafeColor = Color(0xFF5D2600)

@Composable
fun DashboardScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoGeneral)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            HeaderPanel()
            Spacer(modifier = Modifier.height(16.dp))
            TargetasSection(navController)
        }
    }
}

@Composable
fun HeaderPanel() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                FondoPanelColor,
                shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
            )
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Today", fontWeight = FontWeight.Bold, color = Color.DarkGray)
                Text("Domingo", color = Color.DarkGray)
            }

            Box(
                modifier = Modifier
                    .background(
                        PanelCafeColor,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Text(
                    "5 /Oct /25",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun TargetasSection(navController: NavHostController) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    PanelCafeColor,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Targetas",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 🔹 Tarjeta: Personal
        TargetaItem(
            icon = Icons.Default.Person,
            text = "Personal",
            onClick = { navController.navigate(NavRoutes.NOTA_TIPO_PERSONAL) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 🔹 Tarjeta: Recetas
        TargetaItem(
            icon = Icons.Default.Favorite,
            text = "Recetas",
            onClick = { navController.navigate(NavRoutes.NOTA_TIPO_RECETA) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 🔹 Tarjeta: Actividades
        TargetaItem(
            icon = Icons.Default.Create,
            text = "Actividades",
            onClick = { navController.navigate(NavRoutes.NOTA_TIPO_ACTIVIDAD) }
        )
    }
}

@Composable
fun TargetaItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                FondoBotonColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() } // 🔹 Cada tarjeta tiene su propio click
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = text, tint = Color.White) // 🔸 Iconos blancos
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text,
                color = Color.Black,
                fontWeight = FontWeight.Medium
            )
        }
        Text(
            ">",
            color = PanelCafeColor,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}
