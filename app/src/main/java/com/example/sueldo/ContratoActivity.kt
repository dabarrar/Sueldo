package com.example.sueldo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ContratoActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrato)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val resultado = findViewById<TextView>(R.id.tvResultado)
        val brutoEditText = findViewById<EditText>(R.id.bruto)

        btnCalcular.setOnClickListener {
            val bruto = brutoEditText.text.toString().toDoubleOrNull() ?: 0.0
            val empleadoContrato = Contrato(bruto)
            val sueldoLiquido = empleadoContrato.calcularLiquido()

            resultado.text = "El Sueldo líquido es $sueldoLiquido"
        }
    }

    fun volverAtras(view: View) {
        finish()
    }
}
