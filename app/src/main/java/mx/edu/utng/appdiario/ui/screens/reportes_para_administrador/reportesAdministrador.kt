package mx.edu.utng.appdiario.ui.screens.reportes_para_administrador

import android.graphics.Color as AndroidColor
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import mx.edu.utng.appdiario.Repository.UsuarioRepository
import mx.edu.utng.appdiario.local.database.AppDatabase

@Composable
fun ReportesAdmin(navController: NavController) {

    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(AppDatabase.getDatabase(context).usuarioDao())
    val viewModel: ReportesViewModel = viewModel(
        factory = ReportesViewModelFactory(usuarioRepository)
    )
    val state by viewModel.state.collectAsState()

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
                .background(androidx.compose.ui.graphics.Color(0xFF6D3B1A)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "REPORTES",
                color = androidx.compose.ui.graphics.Color.White,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Gráfico de usuarios por mes
        Text(
            text = "Usuarios por Mes",
            fontSize = 20.sp,
            color = androidx.compose.ui.graphics.Color(0xFF4E2A0E)
        )

        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            factory = { ctx ->
                BarChart(ctx).apply {
                    description.isEnabled = false
                    xAxis.position = XAxis.XAxisPosition.BOTTOM
                    axisRight.isEnabled = false
                    legend.isEnabled = false
                }
            },
            update = { chart ->
                val entries = state.usuariosPromedioPorMes.entries.mapIndexed { index, entry ->
                    BarEntry(index.toFloat(), entry.value.toFloat())
                }
                val dataSet = BarDataSet(entries, "Usuarios por Mes").apply {
                    color = AndroidColor.parseColor("#6D3B1A")
                    valueTextColor = AndroidColor.BLACK
                    valueTextSize = 12f
                }
                val barData = BarData(dataSet)
                chart.data = barData
                chart.xAxis.valueFormatter = IndexAxisValueFormatter(
                    state.usuariosPromedioPorMes.keys.toList()
                )
                chart.invalidate()
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 🔹 Gráfico de usuarios por tipo (claramente solo 2 tipos)
        Text(
            text = "Usuarios por Tipo",
            fontSize = 20.sp,
            color = androidx.compose.ui.graphics.Color(0xFF4E2A0E)
        )

        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            factory = { ctx ->
                PieChart(ctx).apply {
                    description.isEnabled = false
                    legend.isEnabled = true
                    setUsePercentValues(true)
                    setEntryLabelColor(AndroidColor.BLACK)
                }
            },
            update = { chart ->
                val entries = state.usuariosPorTipo.entries.map { PieEntry(it.value.toFloat(), it.key) }
                val dataSet = PieDataSet(entries, "Usuarios").apply {
                    colors = listOf(
                        AndroidColor.parseColor("#6D3B1A"), // ADMIN
                        AndroidColor.parseColor("#D9A97C")  // NORMAL
                    )
                    valueTextColor = AndroidColor.BLACK
                    valueTextSize = 12f
                }
                chart.data = PieData(dataSet)
                chart.invalidate()
            }
        )
    }
}
