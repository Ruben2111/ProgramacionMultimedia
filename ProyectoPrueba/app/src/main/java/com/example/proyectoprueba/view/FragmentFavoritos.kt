package com.example.proyectoprueba.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoprueba.databinding.FragmentFavoritosBinding
import com.example.proyectoprueba.viewmodel.EquiposViewModel

class FragmentFavoritos : Fragment() {
    private val viewModel: EquiposViewModel by activityViewModels()

    private lateinit var binding: FragmentFavoritosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFavoritosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listaEquipos.observe(viewLifecycleOwner){
            binding.apply {
                recyclerView.adapter = FavoritosAdapter(viewModel)
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }

        viewModel.equiposFavoritos()
    }

}