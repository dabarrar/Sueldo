package com.example.sueldo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class HonorarioActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaHonorario()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PantallaHonorario() {
    var bruto by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("")}
    val contexto = LocalContext.current as ComponentActivity


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cálculo de Honorario",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            placeholder = {Text("Sueldo Bruto")},
            value = bruto,
            onValueChange = { bruto = it },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
                val sueldoBruto = bruto.toDoubleOrNull() ?: 0.0
                val empleadoHonorario = Honorario(sueldoBruto)
                val sueldoLiquido = empleadoHonorario.calcularLiquido()
                resultado = "El sueldo liquido es de ${sueldoLiquido}"
            }){
            Text("Calcular Sueldo")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(resultado)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { contexto.finish() }) {
            Text("<- Volver")
        }
    }
}

