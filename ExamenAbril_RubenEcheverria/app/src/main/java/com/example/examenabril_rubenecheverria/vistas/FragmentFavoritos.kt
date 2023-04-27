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
import com.example.examenabril_rubenecheverria.databinding.FragmentFavoritosBinding
import com.example.examenabril_rubenecheverria.modelo.Participante
import com.example.examenabril_rubenecheverria.viewmodel.FestivalViewModel

class FragmentFavoritos : Fragment() {

    private val viewModel: FestivalViewModel by activityViewModels()
    private lateinit var navController: NavController
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

        navController = view.findNavController()

        viewModel.listaFavoritos.observe(viewLifecycleOwner){
            binding.apply {
                var lista=viewModel.listaFavoritos.value
                recyclerViewFavoritos.adapter = ParticipanteAdapter(lista){ participante -> onClickParticipante(participante)}
                recyclerViewFavoritos.layoutManager = LinearLayoutManager(context)
                recyclerViewFavoritos.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }

        viewModel.cargarFavoritos()
    }

    private fun onClickParticipante(participante: Participante)
    {
        val accion = FragmentFavoritosDirections.actionFragmentFavoritosToFragmentDetalleParticipante(participante=participante)
        navController.navigate(accion)
    }
}