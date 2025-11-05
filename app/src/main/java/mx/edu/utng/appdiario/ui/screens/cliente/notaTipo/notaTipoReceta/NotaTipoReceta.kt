package mx.edu.utng.appdiario.ui.screens.cliente.notaTipo.notaTipoReceta

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mx.edu.utng.appdiario.navigation.navegacion_global.NavRoutes

@Composable
fun NotaTipoReceta(navController: NavController) {
    var search by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8E5C4))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ---- Encabezado de Fecha ----
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD39C6A), RoundedCornerShape(10.dp))
                .padding(6.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Today",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Box(
                    modifier = Modifier
                        .background(Color(0xFF6E3B09), RoundedCornerShape(6.dp))
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "5 /Oct /25",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
                Text(
                    text = "Domingo",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ---- Botón Recetas ----
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color(0xFFF3B98C), RoundedCornerShape(12.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Favorite, contentDescription = "Recetas", tint = Color.Red)
            Text(
                text = "Recetas",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(Icons.Default.Create, contentDescription = "Ir", tint = Color.Gray)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // ---- Barra de búsqueda con botón "+" ----
        Row(
            modifier = Modifier.fillMaxWidth(0.8f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                placeholder = { Text("Buscar") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color.Gray)
                },
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFF3B98C), RoundedCornerShape(8.dp)),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.LightGray,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Botón "+"
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color(0xFFF3B98C), shape = CircleShape)
                    .clickable {
                        navController.navigate(NavRoutes.CREACION_NOTA_RECETA)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text("+", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ---- Lista de tarjetas ----
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .weight(1f)
        ) {
            val notas = listOf("Receta 1", "Receta 2", "Receta 3", "Receta 4") // Reemplazar con datos reales
            notas.forEach { nota ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = nota, fontSize = 16.sp, fontWeight = FontWeight.Medium)

                        Row {
                            // Botón Editar
                            IconButton(onClick = {navController.navigate(NavRoutes.CREACION_NOTA_RECETA) }) {
                                Icon(
                                    imageVector = Icons.Default.Create,
                                    contentDescription = "Editar",
                                    tint = Color.Blue
                                )
                            }

                            // Botón Eliminar
                            IconButton(onClick = { /* Acción de eliminar */ }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Eliminar",
                                    tint = Color.Red
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
