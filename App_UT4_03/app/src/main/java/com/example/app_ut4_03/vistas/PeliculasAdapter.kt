package com.example.app_ut4_03.vistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut4_03.R
import com.example.app_ut4_03.databinding.ItemPeliculaBinding
import com.example.app_ut4_03.modelo.Pelicula

class PeliculasAdapter(
    private val listaPeliculas: List<Pelicula>?,
    private val cambiarFavorita: (Pelicula) -> Unit
) : RecyclerView.Adapter<PeliculasAdapter.PeliculasViewHolder>()
{

    class PeliculasViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemPeliculaBinding.bind(view)

        fun bind(pelicula:Pelicula, cambiarFavorita: (Pelicula) -> Unit){
            binding.textViewListaTitulo.text = pelicula.titulo
            binding.textViewListaAnho.text = pelicula.anyo.toString()
            binding.textViewListaDirector.text = pelicula.director
            binding.textViewListaPuntos.text = pelicula.puntuacion.toString()

            binding.imagenListaPelicula.setImageResource(R.drawable.no_favorito)
            if(pelicula.favorita){
                binding.imagenListaPelicula.setImageResource(R.drawable.favorito)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pelicula,parent,false)

        return PeliculasViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        if(listaPeliculas?.size!=null) {
            val pelicula = listaPeliculas[position]
            holder.bind(pelicula, cambiarFavorita)
        }
    }

    override fun getItemCount(): Int {
        if(listaPeliculas?.size!=null){
            return listaPeliculas.size
        }else{
            return 0
        }
    }
}