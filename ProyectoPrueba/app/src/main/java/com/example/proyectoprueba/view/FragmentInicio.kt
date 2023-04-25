package com.example.proyectoprueba.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoprueba.databinding.FragmentInicioBinding
import com.example.proyectoprueba.viewmodel.EquiposViewModel


class FragmentInicio : Fragment() {
    private val viewModel: EquiposViewModel by activityViewModels()

    private lateinit var binding: FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentInicioBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listaEquipos.observe(viewLifecycleOwner){
            binding.apply {
                recyclerView.adapter = EquipoAdapter(viewModel)
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }

        viewModel.cargarEquipos()
    }
}