package com.example.app_ut2_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val datos = linkedMapOf<String, Int>(
        "Iván" to R.drawable.avatar3,
        "María" to R.drawable.avatar1,
        "Rosa" to R.drawable.avatar2,
        "Pepe" to R.drawable.avatar4)

    private var cont=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val texto=findViewById<TextView>(R.id.texto)
        val imagen=findViewById<ImageView>(R.id.imagen)
        val boton= findViewById<Button>(R.id.boton)

        boton.setOnClickListener {
            cambiarImagen(texto,imagen)
        }
    }

    private fun cambiarImagen(texto:TextView, imagen:ImageView){
        cont++
        if(cont==4){
            cont=0;
        }

        val key=datos.keys.elementAt(cont)
        texto.text=key
        imagen.setImageResource(datos[key]!!)

        Toast.makeText(this, "Has cambiado el valor a $key", Toast.LENGTH_SHORT).show()
    }
}