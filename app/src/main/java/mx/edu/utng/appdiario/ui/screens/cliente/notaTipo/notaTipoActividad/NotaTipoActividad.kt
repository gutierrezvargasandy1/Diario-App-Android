package mx.edu.utng.appdiario.ui.screens.cliente.notaTipo.notaTipoActividad

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mx.edu.utng.appdiario.navigation.navegacion_global.NavRoutes

@Composable
fun NotaTipoActividad(navController: NavController) {
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

        // ---- Botón Actividades ----
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color(0xFFF3B98C), RoundedCornerShape(12.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Create, contentDescription = "Actividades", tint = Color.Red)
            Text(
                text = "Actividades",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(Icons.Default.ArrowBack, contentDescription = "Ir", tint = Color.Gray)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // ---- Barra de búsqueda con botón "+" ----
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f),
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
                        // Acción para crear nueva nota
                        navController.navigate(NavRoutes.CREACION_NOTA_ACTIVIDAD)
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
            val notas = listOf("Nota 1", "Nota 2", "Nota 3", "Nota 4") // Reemplazar con tus datos
            notas.forEach { nota ->
                Card (
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
                            IconButton(onClick = { navController.navigate(NavRoutes.CREACION_NOTA_ACTIVIDAD) }) {
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


