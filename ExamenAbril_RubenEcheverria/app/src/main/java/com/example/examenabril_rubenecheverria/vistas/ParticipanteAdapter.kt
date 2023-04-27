package com.example.examenabril_rubenecheverria.vistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenabril_rubenecheverria.R
import com.example.examenabril_rubenecheverria.databinding.ItemParticipanteBinding
import com.example.examenabril_rubenecheverria.modelo.Participante

class ParticipanteAdapter(private val participantes: List<Participante>?,
                          private val onClickParticipante: (Participante) -> Unit)

    : RecyclerView.Adapter<ParticipanteAdapter.ParticipanteViewHolder>()
{

    class ParticipanteViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = ItemParticipanteBinding.bind(view)

        fun bind(participante: Participante, onClickParticipante: (Participante) -> Unit)
        {
            binding.imagenParticipante.setImageResource(participante.imagen)
            binding.textViewNombre.text= participante.nombre
            val total= participante.puntosJurado+participante.puntosDemoscopio+participante.puntosTelevoto
            binding.textViewPuntos.text = ""+total+" votos"

            binding.layout.setOnClickListener { onClickParticipante(participante) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipanteViewHolder {
        val adapterLayout= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_participante,parent,false)

        return ParticipanteViewHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: ParticipanteViewHolder, position: Int) {
        if(participantes?.size!=null){
            val part = participantes.get(position)
            holder.bind(part, onClickParticipante)
        }
    }

    override fun getItemCount(): Int {
        if(participantes?.size!=null){
            return participantes.size
        }else{
            return 0
        }
    }
}

