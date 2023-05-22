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
import com.example.app_ut4_03.databinding.FragmentListaFavoritasBinding
import com.example.app_ut4_03.modelo.Pelicula
import com.example.app_ut4_03.viewmodel.PeliculasViewModel


class FragmentListaFavoritas : Fragment() {

    private lateinit var binding:FragmentListaFavoritasBinding
    private lateinit var navController: NavController
    private val peliculasViewModel: PeliculasViewModel by activityViewModels { PeliculasViewModel.Factory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListaFavoritasBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        peliculasViewModel.peliculasFavoritas.observe(viewLifecycleOwner){
            binding.apply {
                var lista=peliculasViewModel.peliculasFavoritas.value
                recyclerViewFavoritas.adapter = PeliculasAdapter(
                    lista,
                    onClickPelicula = { onClickPelicula(it) },
                    cambiarFavorita = { peliculasViewModel.cambiarFavorita(it.id)}
                )
                recyclerViewFavoritas.layoutManager = LinearLayoutManager(context)
            }
        }
    }

    private fun onClickPelicula(pelicula: Pelicula)
    {
        val accion = FragmentListaFavoritasDirections.actionFragmentListaFavoritasToFragmentDetalle(pelicula=pelicula)
        navController.navigate(accion)
    }
}