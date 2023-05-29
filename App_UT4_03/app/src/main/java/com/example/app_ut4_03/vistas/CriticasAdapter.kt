package com.example.app_ut4_03.vistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut4_03.R
import com.example.app_ut4_03.modelo.Critica

class CriticasAdapter(private val listaCriticas: List<Critica>)
    :RecyclerView.Adapter<CriticasAdapter.CriticasViewHolder>()
{
    class CriticasViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textViewCritica= view.findViewById<TextView>(R.id.textViewCritica)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriticasViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_critica,parent,false)

        return CriticasViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CriticasViewHolder, position: Int) {
        val critica = listaCriticas[position]
        holder.textViewCritica.text = critica.texto

        val color= when(critica.valoracion)
        {
            "POS" -> R.color.LimeGreen
            "NEG" -> R.color.PaleVioletRed
            else -> R.color.Snow
        }
        holder.textViewCritica.setBackgroundColor(
            ContextCompat.getColor(holder.textViewCritica.context,color)
        )
    }

    override fun getItemCount(): Int = listaCriticas.size
}