package mx.edu.utng.appdiario.ui.screens.cliente

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PersonalScreen() {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8E5C4))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp) // deja espacio para la barra inferior
                .verticalScroll(rememberScrollState()),
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
                    imageVector = Icons.Default.Person,
                    contentDescription = "Personal",
                    tint = Color.Red
                )
                Text(
                    text = "Personal",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Ir",
                    tint = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // ---- Campo de título ----
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                placeholder = { Text("Título") },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(Color(0xFFF3B98C), RoundedCornerShape(8.dp)),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.LightGray,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ---- Íconos de opciones ----
            Row(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(Icons.Default.Face, contentDescription = "Emoji", tint = Color(0xFFFCBA03))
                Icon(Icons.Default.AccountBox, contentDescription = "Imagen", tint = Color(0xFF4472C4))
                Icon(Icons.Default.Edit, contentDescription = "Editar", tint = Color(0xFFFC4F03))
            }

            Spacer(modifier = Modifier.height(4.dp))

            // ---- Campo de texto ----
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                Text(text = "Texto", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    placeholder = { Text("Escribe algo...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .background(Color.Transparent, RoundedCornerShape(6.dp)),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedContainerColor = Color(0xFFF8F8F8),
                        focusedContainerColor = Color(0xFFF8F8F8),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ---- Botones Eliminar / Micrófono / Agregar ----
            Row(
                modifier = Modifier.fillMaxWidth(0.9f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /* eliminar acción */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF3B98C)),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text("Eliminar", color = Color.Black)
                }

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Mic",
                    tint = Color.Black,
                    modifier = Modifier.size(32.dp)
                )

                Button(
                    onClick = { /* agregar acción */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF3B98C)),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text("Agregar", color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        // ---- Barra inferior fija ----
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color(0xFF6E3B09))
                .padding(vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White)
            Icon(Icons.Default.List, contentDescription = "Calendario", tint = Color.White)
            Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.White)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PersonalScreenPreview() {
    PersonalScreen()
}


