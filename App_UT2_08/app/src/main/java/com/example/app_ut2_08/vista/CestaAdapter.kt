package com.example.app_ut2_08.vista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut2_08.R
import com.example.app_ut2_08.viewmodel.ProductosViewModel

class CestaAdapter(val viewModel: ProductosViewModel):RecyclerView.Adapter<CestaAdapter.CestaViewHolder>(){

    val productos = viewModel.listaCompra.value

    class CestaViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
        val textViewNombre = view.findViewById<TextView>(R.id.textViewCestaNombre)
        val imageViewProducto = view.findViewById<ImageView>(R.id.imageViewItemCesta)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CestaViewHolder {
        val adapterLayout= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cesta,parent,false)

        return CestaViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CestaViewHolder, position: Int) {
        if(productos?.size!=null){
            val producto = productos.get(position)
            holder.textViewNombre.text = producto.nombre
            holder.imageViewProducto.setImageResource(producto.imagenId)
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