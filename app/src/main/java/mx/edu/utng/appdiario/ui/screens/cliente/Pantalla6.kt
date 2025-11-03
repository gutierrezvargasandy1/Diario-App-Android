package mx.edu.utng.appdiario.ui.screens.cliente

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun ResetasScreen3() {
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

        // ---- Botón Personal ----
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color(0xFFF3B98C), RoundedCornerShape(12.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Resetas",
                tint = Color.Red
            )
            Text(
                text = "Resetas",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Ir",
                tint = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // ---- Barra de búsqueda MODIFICADA ----
        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            placeholder = { Text("Buscar") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color.Gray)
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color(0xFFF3B98C), RoundedCornerShape(8.dp)),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.LightGray,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // ---- Lista de ítems ----
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(240.dp)
                .border(2.dp, Color.Gray, RoundedCornerShape(6.dp))
                .background(Color.White, RoundedCornerShape(6.dp))
        ) {
            repeat(4) { index ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                ) {
                    Text(
                        text = "List item",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
                if (index < 3) {
                    Divider(color = Color.LightGray, thickness = 1.dp)
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // ---- Botón flotante inferior derecho ----
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .shadow(6.dp, shape = CircleShape)
                    .background(Color(0xFFF3B98C), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Agregar",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(280.dp))

        // ---- Barra inferior ----
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF6E3B09))
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White)
            Icon(Icons.Default.List, contentDescription = "Calendario", tint = Color.White)
            Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.White)
        }
    }
}

@Preview(showBackground = true, name = "Personal Screen Preview")
@Composable
fun ResetasPersonalScreen() {
    ResetaScreen()
}
