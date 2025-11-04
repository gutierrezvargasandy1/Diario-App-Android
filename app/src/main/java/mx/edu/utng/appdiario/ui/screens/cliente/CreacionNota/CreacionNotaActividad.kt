package mx.edu.utng.appdiario.ui.screens.cliente.CreacionNota

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun CreacionNotaActividad() {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier.Companion
            .fillMaxSize()
            .background(Color(0xFFF8E5C4))
    ) {
        Column(
            modifier = Modifier.Companion
                .fillMaxSize()
                .padding(bottom = 60.dp) // deja espacio para la barra inferior
                .verticalScroll(rememberScrollState()),
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
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Companion.Bold
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Ir",
                    tint = Color.Companion.Gray
                )
            }

            Spacer(modifier = Modifier.Companion.height(10.dp))

            // ---- Campo de título ----
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                placeholder = { Text("Título") },
                modifier = Modifier.Companion
                    .fillMaxWidth(0.9f)
                    .background(
                        Color(0xFFF3B98C),
                        androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                    ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Companion.Text),
                singleLine = true,
                maxLines = 1,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Companion.LightGray,
                    unfocusedContainerColor = Color.Companion.White,
                    focusedIndicatorColor = Color.Companion.Transparent,
                    unfocusedIndicatorColor = Color.Companion.Transparent
                )
            )

            Spacer(modifier = Modifier.Companion.height(8.dp))

            // ---- Íconos de opciones ----
            Row(
                modifier = Modifier.Companion.fillMaxWidth(0.8f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(Icons.Default.Face, contentDescription = "Emoji", tint = Color(0xFFFCBA03))
                Icon(
                    Icons.Default.AccountBox,
                    contentDescription = "Imagen",
                    tint = Color(0xFF4472C4)
                )
                Icon(Icons.Default.Edit, contentDescription = "Editar", tint = Color(0xFFFC4F03))
            }

            Spacer(modifier = Modifier.Companion.height(4.dp))

            // ---- Campo de texto ----
            Column(
                horizontalAlignment = Alignment.Companion.Start,
                modifier = Modifier.Companion.fillMaxWidth(0.9f)
            ) {
                Text(text = "Texto", fontWeight = FontWeight.Companion.Bold)
                Spacer(modifier = Modifier.Companion.height(4.dp))
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    placeholder = { Text("Escribe algo...") },
                    modifier = Modifier.Companion
                        .fillMaxWidth()
                        .height(140.dp)
                        .background(
                            Color.Companion.Transparent,
                            androidx.compose.foundation.shape.RoundedCornerShape(6.dp)
                        ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Companion.Text),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Companion.Black,
                        unfocusedContainerColor = Color(0xFFF8F8F8),
                        focusedContainerColor = Color(0xFFF8F8F8),
                        focusedIndicatorColor = Color.Companion.Transparent,
                        unfocusedIndicatorColor = Color.Companion.Transparent
                    )
                )
            }

            Spacer(modifier = Modifier.Companion.height(8.dp))

            // ---- Botones Eliminar / Micrófono / Agregar ----
            Row(
                modifier = Modifier.Companion.fillMaxWidth(0.9f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Companion.CenterVertically
            ) {
                Button(
                    onClick = { /* eliminar acción */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF3B98C)),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(6.dp)
                ) {
                    Text("Eliminar", color = Color.Companion.Black)
                }

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Mic",
                    tint = Color.Companion.Black,
                    modifier = Modifier.Companion.size(32.dp)
                )

                Button(
                    onClick = { /* agregar acción */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF3B98C)),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(6.dp)
                ) {
                    Text("Agregar", color = Color.Companion.Black)
                }
            }

            Spacer(modifier = Modifier.Companion.height(16.dp))
        }

        // ---- Barra inferior fija ----
        Row(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .align(Alignment.Companion.BottomCenter)
                .background(Color(0xFF6E3B09))
                .padding(vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Companion.CenterVertically
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ActividadesScreenPreview() {
    CreacionNotaActividad()
}