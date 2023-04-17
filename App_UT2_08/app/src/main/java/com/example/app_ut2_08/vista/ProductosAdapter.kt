package com.example.app_ut2_08.vista

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut2_08.R
import com.example.app_ut2_08.viewmodel.ProductosViewModel

class ProductosAdapter(val viewModel: ProductosViewModel):
    RecyclerView.Adapter<ProductosAdapter.ProductosViewHolder>()
{
    val productos = viewModel.listaProductos.value

    class ProductosViewHolder(view: View):RecyclerView.ViewHolder(view){

        val textViewNombre = view.findViewById<TextView>(R.id.textViewItemProducto)
        val imageViewProducto = view.findViewById<ImageView>(R.id.imageViewItemProducto)
        val botonComprar = view.findViewById<ImageButton>(R.id.imageButtonItemProducto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val adapterLayout= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent,false)

        return ProductosViewHolder(adapterLayout)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        if(productos?.size!=null){
            val producto = productos.get(position)
            holder.textViewNombre.text = producto.nombre
            holder.imageViewProducto.setImageResource(producto.imagenId)
            holder.botonComprar.setOnClickListener { viewModel.insertarCesta(producto) }
        }
    }

    override fun getItemCount(): Int {
        if(productos?.size!=null){
            return productos.size
        }else{
            return 0
        }
    }
}