package com.example.examenabril_rubenecheverria.vistas

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.examenabril_rubenecheverria.R
import com.example.examenabril_rubenecheverria.databinding.FragmentDetalleParticipanteBinding
import com.example.examenabril_rubenecheverria.modelo.Participante
import com.example.examenabril_rubenecheverria.viewmodel.FestivalViewModel

class FragmentDetalleParticipante : Fragment() {

    private val viewModel: FestivalViewModel by activityViewModels()
    private lateinit var binding: FragmentDetalleParticipanteBinding
    private lateinit var participante: Participante
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            participante = it.get("participante") as Participante
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetalleParticipanteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        binding.imageViewDetalle.setImageResource(participante.imagen)
        binding.textViewDetalleNom.text= participante.nombre
        binding.textViewDetalleCan.text=participante.cancion
        binding.editTextDetalleJurado.setText(participante.puntosJurado.toString())

        binding.seekBarDetalleDem.setOnTouchListener({_,_ ->true})
        binding.seekBarDetalleDem.progress = participante.puntosJurado

        binding.imagenDetalleFav.setImageResource(R.drawable.ic_no_favorito)
        if(participante.favorito){
            binding.imagenDetalleFav.setImageResource(R.drawable.ic_favorito)
        }

        binding.imagenDetalleFav.setOnClickListener {
            if(participante.favorito){
                AlertDialog.Builder(requireContext())
                    .setTitle("¿Cambiar favorito?")
                    .setMessage("¿Esta seguro de que desea borrar de favorito a "+participante.nombre+"?")
                    .setCancelable(false)
                    .setPositiveButton(R.string.si) { _, _ ->
                        viewModel.cambiarFavorito(participante)
                        navController.navigate(R.id.action_fragmentDetalleParticipante_to_fragmentParticipantes2)
                    }
                    .show()
            }else{
                AlertDialog.Builder(requireContext())
                    .setTitle("¿Cambiar favorito?")
                    .setMessage("¿Esta seguro de que desea añadir como favorito a "+participante.nombre+"?")
                    .setCancelable(false)
                    .setPositiveButton(R.string.si) { _, _ ->
                        viewModel.cambiarFavorito(participante)
                        navController.navigate(R.id.action_fragmentDetalleParticipante_to_fragmentParticipantes2)

                    }
                    .show()
            }
        }
    }


}