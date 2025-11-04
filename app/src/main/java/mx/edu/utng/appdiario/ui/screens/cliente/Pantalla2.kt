package mx.edu.utng.appdiario.ui.screens.cliente



import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
            TargetasSection()
        }
        BottomNavigationBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun HeaderPanel() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(FondoPanelColor, shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
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
                    .background(PanelCafeColor, shape = RoundedCornerShape(6.dp))
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
fun TargetasSection() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PanelCafeColor, shape = RoundedCornerShape(4.dp))
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

        TargetaItem(
            icon = Icons.Default.Person,
            text = "Personal"
        )

        Spacer(modifier = Modifier.height(8.dp))

        TargetaItem(
            icon = Icons.Default.Favorite,
            text = "Recetas"
        )

        Spacer(modifier = Modifier.height(8.dp))

        TargetaItem(
            icon = Icons.Default.Create,
            text = "Actividades"
        )
    }
}

@Composable
fun TargetaItem(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(FondoBotonColor, shape = RoundedCornerShape(12.dp))
            .clickable { }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = text, tint = PanelCafeColor)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text, color = Color.Black, fontWeight = FontWeight.Medium)
        }
        Text(">", color = PanelCafeColor, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(FondoPanelColor)
            .padding(vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Home, contentDescription = "Inicio", tint = PanelCafeColor)
            Icon(Icons.Default.List, contentDescription = "Calendario", tint = PanelCafeColor)
            Icon(Icons.Default.Person, contentDescription = "Perfil", tint = PanelCafeColor)
        }
    }
}

