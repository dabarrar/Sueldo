package com.example.sueldo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicio()
        }
    }
}
@Preview
@Composable
fun PantallaInicio() {
    val contexto = LocalContext.current as ComponentActivity
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calculo de Sueldo",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(modifier = Modifier.height(60.dp).width(150.dp), onClick = {
            val intent: Intent = Intent(contexto, HonorarioActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Honorario")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier.height(60.dp).width(150.dp), onClick = {
            val intent: Intent = Intent(contexto, ContratoActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Contrato")
        }
    }
}

