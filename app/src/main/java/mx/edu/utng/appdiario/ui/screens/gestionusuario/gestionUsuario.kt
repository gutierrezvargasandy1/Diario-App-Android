package mx.edu.utng.appdiario.ui.screens.gestionusuario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GestionUsuarios(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5E6D3))
    ) {
        // 🔹 Encabezado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF8B4513))
                .padding(16.dp)
        ) {
            Text(
                text = "Gestión de Usuarios",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(13.dp))

        // 🔹 Campo de búsqueda
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Buscar usuario") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color.Gray
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Contenido principal (placeholder)
        Text(
            text = "Aquí aparecerá la lista de usuarios registrados o las opciones de gestión.",
            fontSize = 16.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(16.dp)
        )
    }
}
