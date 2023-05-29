package com.example.app_ut4_03.vistas

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import coil.load
import com.example.app_ut4_03.R
import com.example.app_ut4_03.databinding.FragmentNuevaPeliculaBinding
import com.example.app_ut4_03.modelo.Pelicula
import com.example.app_ut4_03.viewmodel.PeliculasViewModel


class FragmentNuevaPelicula : Fragment() {

    private lateinit var binding:FragmentNuevaPeliculaBinding
    private lateinit var navController: NavController
    private val peliculasViewModel: PeliculasViewModel by activityViewModels { PeliculasViewModel.Factory}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNuevaPeliculaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        binding.apply {
            editTextNuevaUrlImagen.setOnFocusChangeListener { _, foco ->
                if(!foco && editTextNuevaUrlImagen.text.toString().isNotEmpty())
                {
                    val userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36"
                    val url = editTextNuevaUrlImagen.text.toString()
                    imageViewNuevaPelicula.load(url)
                    {
                        addHeader("User-Agent", userAgent)
                    }
                }
            }


            buttonNuevaInsertar.setOnClickListener {
                var titulo:String = editTextNuevaTitulo.text.toString()
                var anyo:Int = editTextNuevaAnho.text.toString().toInt()
                var director:String? =editTextNuevaDirector.text.toString()
                var puntos:Float = editTextNuevaPuntuacion.text.toString().toFloat()
                var imagen:String?= editTextNuevaUrlImagen.text.toString()
                var sinopsis:String= editTextNuevaSinopsis.text.toString()

                peliculasViewModel.insertarPelicula(
                    Pelicula(0, titulo, anyo, director, puntos, imagen, sinopsis, false)
                )
                navController.navigate(R.id.action_fragmentNuevaPelicula_to_fragmentListaPeliculas)
            }
        }
    }
}