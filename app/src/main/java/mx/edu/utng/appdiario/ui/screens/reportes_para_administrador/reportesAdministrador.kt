package mx.edu.utng.appdiario.ui.screens.reportes_para_administrador

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable


fun ReportesAdmin(navController: NavController)
{
    val scrollState = rememberScrollState() ////val para el scrol hay que recordar
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5E6D3))
            .verticalScroll(scrollState), /////Este es el scroll,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        // Título principal
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFF6D3B1A))
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "REPORTES",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Gráfico de usuarios
        Text(
            text = "Usuarios por Mes",
            color = Color(0xFF4E2A0E),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        // Ejemplo visual del gráfico
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color(0xFFFFF1D6))
                .border(1.dp, Color.Gray)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Segundo gráfico
        Text(
            text = "Secciones Activas",
            color = Color(0xFF4E2A0E),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color(0xFFFFF1D6))
                .border(1.dp, Color.Gray)
        )
    }
}
