package com.example.app_ut4_03.vistas

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import coil.load
import com.example.app_ut4_03.R
import com.example.app_ut4_03.databinding.FragmentDetalleBinding
import com.example.app_ut4_03.modelo.Pelicula
import com.example.app_ut4_03.viewmodel.PeliculasViewModel


class FragmentDetalle : Fragment() {

    private lateinit var binding:FragmentDetalleBinding
    private lateinit var pelicula: Pelicula
    private lateinit var navController: NavController
    private val peliculasViewModel: PeliculasViewModel by activityViewModels { PeliculasViewModel.Factory}

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pelicula = it.get("pelicula") as Pelicula
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetalleBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        binding.apply {
            textViewDetalleTitulo.text=pelicula.titulo
            textViewDetalleDirector.text=pelicula.director
            textViewDetalleSinopsis.text=pelicula.sinopsis

            if(pelicula.favorita){
                binding.imageViewDetalleEstrella.setImageResource(R.drawable.favorito)
            }

            val userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36"
            val url = pelicula.imagen
            imageViewDetallePelicula.load(url)
            {
                addHeader("User-Agent", userAgent)
            }

            imageViewDetalleCriticas.setOnClickListener {
                val accion= FragmentDetalleDirections.actionFragmentDetalleToFragmentCriticas(peliculaId = pelicula.id)
                navController.navigate(accion)
            }

            imageViewDetallePapelera.setOnClickListener{
                AlertDialog.Builder(requireContext())
                    .setTitle("¿Borrar pelicula?")
                    .setMessage("¿Esta seguro de que desea borrar la pelicula"+pelicula.titulo+"?")
                    .setCancelable(true)
                    .setNegativeButton(R.string.no){_, _ ->
                        Toast.makeText(context, "No se ha borrado la pelicula "+pelicula.titulo+".", Toast.LENGTH_SHORT).show()
                    }
                    .setPositiveButton(R.string.si) { _, _ ->
                        peliculasViewModel.borrarPelicula(pelicula)
                        navController.navigate(R.id.action_fragmentDetalle_to_fragmentListaPeliculas)
                    }
                    .show()
            }
        }
    }
}