package com.example.app_ut4_03.vistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.app_ut4_03.R
import com.example.app_ut4_03.databinding.ItemPeliculaBinding
import com.example.app_ut4_03.modelo.Pelicula

class PeliculasAdapter (
    private val listaPeliculas: List<Pelicula>?,
    private val onClickPelicula: (Pelicula) ->Unit,
    private val cambiarFavorita: (Pelicula) -> Unit,
    private val crearNotificacion: (Pelicula) ->Unit,
) : RecyclerView.Adapter<PeliculasAdapter.PeliculasViewHolder>()
{

    class PeliculasViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemPeliculaBinding.bind(view)

        fun bind(pelicula:Pelicula, onClickPelicula: (Pelicula) -> Unit, cambiarFavorita: (Pelicula) -> Unit, crearNotificacion: (Pelicula) -> Unit){
            binding.textViewListaTitulo.text = pelicula.titulo
            binding.textViewListaAnho.text = pelicula.anyo.toString()
            binding.textViewListaDirector.text = pelicula.director
            binding.textViewListaPuntos.text = pelicula.puntuacion.toString()

            binding.imageViewListaEstrella.setImageResource(R.drawable.no_favorito)
            if(pelicula.favorita){
                binding.imageViewListaEstrella.setImageResource(R.drawable.favorito)
            }

            binding.layout.setOnClickListener { onClickPelicula (pelicula) }
            binding.imageViewListaEstrella.setOnClickListener {
                cambiarFavorita (pelicula)
                crearNotificacion (pelicula)
            }

            val userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36"
            val url = pelicula.imagen
            binding.imagenListaPelicula.load(url)
            {
                addHeader("User-Agent", userAgent)
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
            holder.bind(pelicula, onClickPelicula, cambiarFavorita, crearNotificacion)
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