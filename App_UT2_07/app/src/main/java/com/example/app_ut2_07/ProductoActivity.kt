package com.example.app_ut2_07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.app_ut2_07.modelo.Producto

class ProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val producto = intent.extras?.get("producto") as Producto

        var nombre=findViewById<TextView>(R.id.textViewDetalles)
        var imagen=findViewById<ImageView>(R.id.imageViewDetalle)

        nombre.text=producto.nombre
        imagen.setImageResource(producto.imagen)
    }
}