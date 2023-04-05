package com.example.app_ut2_07.modelo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut2_07.R
import com.example.app_ut2_07.datos.Datos

class ProductoAdapter (categoria:String, private val onClickProducto: (Producto) -> Unit):
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>()
{
    private val productos=Datos.getProductosCategoria(categoria)

    class ProductoViewHolder (view: View, private val onClickProducto: (Int) -> Unit):
        RecyclerView.ViewHolder(view)
    {
        val nombre = view.findViewById<TextView>(R.id.textViewProducto)

        init {
            view.setOnClickListener { onClickProducto(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto,parent,false)

        return ProductoViewHolder(adapterLayout,{pos->onClickProducto(productos[pos])})
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.nombre.text = producto.nombre
    }

    override fun getItemCount(): Int = productos.size
}