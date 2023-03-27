package com.example.app_ut2_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.app_ut2_04.modelo.Animal

class DetalleAnimalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_animal)

        val animal = intent.extras?.get("animal") as Animal

        var nombre=findViewById<TextView>(R.id.textNombreDetalle)
        var descripcion=findViewById<TextView>(R.id.textDescripcionDetalle)
        var imagen=findViewById<ImageView>(R.id.imagenDetalle)

        nombre.text=animal.nombre
        descripcion.text=animal.descripcion
        imagen.setImageResource(animal.imagenId)
    }
}