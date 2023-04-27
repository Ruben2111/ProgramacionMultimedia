package com.example.examenabril_rubenecheverria.vistas

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
import com.example.examenabril_rubenecheverria.R
import com.example.examenabril_rubenecheverria.databinding.FragmentParticipantesBinding
import com.example.examenabril_rubenecheverria.modelo.Participante
import com.example.examenabril_rubenecheverria.viewmodel.FestivalViewModel

class FragmentParticipantes : Fragment() {

    private val viewModel: FestivalViewModel by activityViewModels()
    private lateinit var navController: NavController
    private lateinit var binding: FragmentParticipantesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentParticipantesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        viewModel.listaParticipantes.observe(viewLifecycleOwner){
            binding.apply {
                var lista=viewModel.listaParticipantes.value
                recyclerViewParticipantes.adapter = ParticipanteAdapter(lista){ participante -> onClickParticipante(participante)}
                recyclerViewParticipantes.layoutManager = LinearLayoutManager(context)
                recyclerViewParticipantes.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }

        viewModel.cargarParticipantes()
    }

    private fun onClickParticipante(participante: Participante)
    {
        val accion = FragmentParticipantesDirections.actionFragmentParticipantesToFragmentDetalleParticipante(participante=participante)
        navController.navigate(accion)
    }
}