package com.example.app_ut4_03.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_ut4_03.databinding.FragmentCriticasBinding
import com.example.app_ut4_03.viewmodel.PeliculasViewModel


class FragmentCriticas : Fragment() {

    private lateinit var binding: FragmentCriticasBinding
    private var idPelicula: Long = 0
    private val peliculasViewModel: PeliculasViewModel by activityViewModels { PeliculasViewModel.Factory}


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idPelicula = it.getLong("peliculaId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCriticasBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        peliculasViewModel.getCriticas(idPelicula).observe(viewLifecycleOwner){
            with(binding.recyclerViewCriticas){
                adapter=CriticasAdapter(it)
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
}