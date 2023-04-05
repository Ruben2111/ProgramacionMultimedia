package com.example.app_ut2_07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut2_07.datos.Datos
import com.example.app_ut2_07.modelo.Producto
import com.example.app_ut2_07.modelo.ProductoAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val opciones= Datos.nombresCategorias()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,opciones)

        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapter

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long)
            {
                val texto = p0?.selectedItem.toString()
                recyclerView.adapter= ProductoAdapter(texto){ producto -> onClickProducto(producto)}
            }

            override fun onNothingSelected(p0: AdapterView<*>?)
            {
            }
        }
    }

    private fun onClickProducto(producto: Producto)
    {
        val intent = Intent(applicationContext, ProductoActivity::class.java)
        intent.putExtra("producto", producto)
        startActivity(intent)
    }
}