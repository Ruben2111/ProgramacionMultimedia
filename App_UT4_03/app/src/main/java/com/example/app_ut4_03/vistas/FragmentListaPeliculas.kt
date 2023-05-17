package com.example.app_ut4_03.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_ut4_03.databinding.FragmentListaPeliculasBinding
import com.example.app_ut4_03.modelo.Pelicula
import com.example.app_ut4_03.viewmodel.PeliculasViewModel


class FragmentListaPeliculas : Fragment() {

    private lateinit var navController: NavController
    private lateinit var binding:FragmentListaPeliculasBinding
    private val peliculasViewModel: PeliculasViewModel by activityViewModels {PeliculasViewModel.Factory}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListaPeliculasBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        peliculasViewModel.peliculas.observe(viewLifecycleOwner){
            binding.apply {
                var lista=peliculasViewModel.peliculas.value
                recyclerViewPeliculas.adapter = PeliculasAdapter(lista){ pelicula -> onClickPelicula(pelicula) }
                recyclerViewPeliculas.layoutManager = LinearLayoutManager(context)
                recyclerViewPeliculas.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }
    }

    private fun onClickPelicula(pelicula: Pelicula)
    {
        //val accion = FragmentParticipantesDirections.actionFragmentParticipantesToFragmentDetalleParticipante(participante=participante)
        //navController.navigate(accion)
    }
}