package mx.edu.utng.appdiario.ui.screens.cliente.NotaTipo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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

@Composable
fun NotaTipoActividad() {
    var search by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(Color(0xFFF8E5C4))
            .padding(8.dp),
        horizontalAlignment = Alignment.Companion.CenterHorizontally
    ) {
        // ---- Encabezado de Fecha ----
        Box(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .background(Color(0xFFD39C6A), RoundedCornerShape(10.dp))
                .padding(6.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Companion.CenterHorizontally,
                modifier = Modifier.Companion.fillMaxWidth()
            ) {
                Text(
                    text = "Today",
                    color = Color.Companion.White,
                    fontWeight = FontWeight.Companion.Bold,
                    fontSize = 14.sp
                )
                Box(
                    modifier = Modifier.Companion
                        .background(
                            Color(0xFF6E3B09),
                            androidx.compose.foundation.shape.RoundedCornerShape(6.dp)
                        )
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "5 /Oct /25",
                        color = Color.Companion.White,
                        fontWeight = FontWeight.Companion.Bold,
                        fontSize = 16.sp
                    )
                }
                Text(
                    text = "Domingo",
                    color = Color.Companion.White,
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.Companion.height(12.dp))

        // ---- Botón Personal ----
        Row(
            modifier = Modifier.Companion
                .fillMaxWidth(0.8f)
                .background(
                    Color(0xFFF3B98C),
                    androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
                )
                .padding(horizontal = 12.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Create,
                contentDescription = "Actividades",
                tint = Color.Companion.Red
            )
            Text(
                text = "Actividades",
                color = Color.Companion.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Companion.Bold
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Ir",
                tint = Color.Companion.Gray
            )
        }

        Spacer(modifier = Modifier.Companion.height(10.dp))

        // ---- Barra de búsqueda MODIFICADA ----
        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            placeholder = { Text("Buscar") },
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color.Companion.Gray
                )
            },
            modifier = Modifier.Companion
                .fillMaxWidth(0.8f)
                .background(
                    Color(0xFFF3B98C),
                    androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Companion.Email),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Companion.LightGray,
                unfocusedContainerColor = Color.Companion.White,
                focusedIndicatorColor = Color.Companion.Transparent,
                unfocusedIndicatorColor = Color.Companion.Transparent
            )
        )

        Spacer(modifier = Modifier.Companion.height(12.dp))

        // ---- Lista de ítems ----
        Column(
            modifier = Modifier.Companion
                .fillMaxWidth(0.9f)
                .height(240.dp)
                .border(
                    2.dp,
                    Color.Companion.Gray,
                    androidx.compose.foundation.shape.RoundedCornerShape(6.dp)
                )
                .background(
                    Color.Companion.White,
                    androidx.compose.foundation.shape.RoundedCornerShape(6.dp)
                )
        ) {
            repeat(4) { index ->
                Box(
                    modifier = Modifier.Companion
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                ) {
                    Text(
                        text = "List item",
                        fontSize = 16.sp,
                        modifier = Modifier.Companion.padding(start = 16.dp)
                    )
                }
                if (index < 3) {
                    Divider(color = Color.Companion.LightGray, thickness = 1.dp)
                }
            }
        }

        Spacer(modifier = Modifier.Companion.height(40.dp))

        // ---- Botón flotante inferior derecho ----
        Box(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(end = 24.dp),
            contentAlignment = Alignment.Companion.CenterEnd
        ) {
            Box(
                modifier = Modifier.Companion
                    .size(48.dp)
                    .shadow(6.dp, shape = CircleShape)
                    .background(Color(0xFFF3B98C), shape = CircleShape),
                contentAlignment = Alignment.Companion.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Agregar",
                    tint = Color.Companion.White,
                    modifier = Modifier.Companion.size(28.dp)
                )
            }
        }

        Spacer(modifier = Modifier.Companion.height(280.dp))

        // ---- Barra inferior ----
        Row(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .background(Color(0xFF6E3B09))
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Companion.White)
            Icon(
                Icons.Default.List,
                contentDescription = "Calendario",
                tint = Color.Companion.White
            )
            Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.Companion.White)
        }
    }
}

@Preview(showBackground = true, name = "Personal Screen Preview")
@Composable
fun ActividadesPersonalScreen() {
    NotaTipoActividad()
}