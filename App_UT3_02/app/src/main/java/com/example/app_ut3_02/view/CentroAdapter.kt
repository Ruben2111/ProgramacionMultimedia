package com.example.app_ut3_02.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut3_02.R
import com.example.app_ut3_02.databinding.ItemCentroBinding
import com.example.app_ut3_02.model.Centro


class CentroAdapter(private val listaCentros: List<Centro>,
                    private val onClickCentro: (Centro) -> Unit)
    :RecyclerView.Adapter<CentroAdapter.CentroViewHolder>()
{

    class CentroViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = ItemCentroBinding.bind(view)

        fun bind(centro: Centro, onClickCentro: (Centro) -> Unit)
        {
            binding.textViewNombre.text = centro.nombre
            binding.textViewNombre.setOnClickListener{onClickCentro(centro)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CentroViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_centro,parent ,false)

        return CentroViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CentroViewHolder, position: Int) {
        val centro = listaCentros[position]
        holder.bind(centro, onClickCentro)
    }

    override fun getItemCount(): Int =listaCentros.size
}