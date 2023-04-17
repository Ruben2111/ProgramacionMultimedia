package es.ivanlorenzo.app_ut3_01.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.ivanlorenzo.app_ut3_01.R
import es.ivanlorenzo.app_ut3_01.databinding.ItemAnimalBinding
import es.ivanlorenzo.app_ut3_01.model.Animal

class AnimalAdapter(private val listaAnimales: List<Animal>,
                    private val onClickAnimal: (Animal) -> Unit)
    : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>()
{

    class AnimalViewHolder(view: View)
        : RecyclerView.ViewHolder(view)
    {
        private val binding = ItemAnimalBinding.bind(view)

        fun bind(animal: Animal, onClickAnimal: (Animal) -> Unit)
        {
            binding.textViewNombreAnimal.text = animal.nombre
            val resID = itemView.context.resources.getIdentifier(animal.imagenURL, "drawable",
                itemView.context.packageName)
            binding.imageViewFotoAnimal.setImageResource(resID)
            binding.textViewVotos.text = "${animal.votos} ${if(animal.votos==1) "voto" else "votos"}"
            binding.layout.setOnClickListener { onClickAnimal(animal) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder
    {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)

        return AnimalViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int)
    {
        val animal = listaAnimales[position]
        holder.bind(animal, onClickAnimal)
    }

    override fun getItemCount(): Int = listaAnimales.size



}