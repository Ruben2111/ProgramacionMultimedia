package com.example.app_ut2_04.modelo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut2_04.R
import com.example.app_ut2_04.datos.DatosAnimales

class AnimalAdapter(private val onClickAnimal: (Animal) -> Unit):
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>()
{

    private val listaAnimales = DatosAnimales.getDatosAnimales()

    class AnimalViewHolder(view: View, private val onClickAnimal: (Int) -> Unit):
        RecyclerView.ViewHolder(view){
            val textViewNombreAnimal = view.findViewById<TextView>(R.id.textViewNombreAnimal)
            val imageViewAnimal= view.findViewById<ImageView>(R.id.imagenAnimal)
            val votos= view.findViewById<TextView>(R.id.textViewVotos)

            init {
                view.setOnClickListener { onClickAnimal(adapterPosition) }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)

        return AnimalViewHolder(adapterLayout,{pos->onClickAnimal(listaAnimales[pos])})
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = listaAnimales[position]
        holder.textViewNombreAnimal.text = animal.nombre
        holder.imageViewAnimal.setImageResource(animal.imagenId)
        holder.votos.text=""+animal.votos+" votos"
    }

    override fun getItemCount(): Int = listaAnimales.size

    @SuppressLint("NotifyDataSetChanged")
    fun addAnimal(nombre: String)
    {
        val animal= Animal(nombre,R.drawable.desconocido,"",0)
        listaAnimales.add(animal)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun cambiarVoto(nombre:String, voto:Int)
    {
        val animal=listaAnimales.first { animal-> animal.nombre==nombre }
        animal.votos+=voto
        notifyDataSetChanged()
    }

}