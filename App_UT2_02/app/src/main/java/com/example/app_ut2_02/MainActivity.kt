package com.example.app_ut2_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var contador=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonMostrar=findViewById<Button>(R.id.botonMostrar)
        val botonContar=findViewById<Button>(R.id.botonContar)

        botonContar.setOnClickListener{
            contar()
        }
        botonMostrar.setOnClickListener{
            mostrarToast()
        }
    }

    private fun contar()
    {
        contador++
    }

    private fun mostrarToast()
    {
        val text=findViewById<TextView>(R.id.textView)
        text.text=contador.toString()
        Toast.makeText(this, "Se ha pulsado el boton $contador veces.", Toast.LENGTH_SHORT).show()
    }
}