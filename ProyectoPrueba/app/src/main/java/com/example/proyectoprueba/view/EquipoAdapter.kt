package com.example.proyectoprueba.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoprueba.R
import com.example.proyectoprueba.viewmodel.EquiposViewModel

class EquipoAdapter(val viewModel: EquiposViewModel): RecyclerView.Adapter<EquipoAdapter.EquipoViewHolder>(){

    val equipos = viewModel.listaEquipos.value

    class EquipoViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textViewNombre = view.findViewById<TextView>(R.id.textViewEquipo)
        val imageViewBandera = view.findViewById<ImageView>(R.id.imageViewBandera)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipoViewHolder {
        val adapterLayout= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_equipo,parent,false)

        return EquipoViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: EquipoViewHolder, position: Int) {
        if(equipos?.size!=null){
            val equipo = equipos.get(position)
            holder.textViewNombre.text = equipo.nombre
            holder.imageViewBandera.setImageResource(equipo.bandera)
        }
    }

    override fun getItemCount(): Int {
        if(equipos?.size!=null){
            return equipos.size
        }else{
            return 0
        }
    }
}
