package com.example.app_ut2_06

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app_ut2_06.databinding.FragmentResumenBinding
import com.example.app_ut2_06.modelo.ReservaZooViewModel
import java.util.*


class FragmentResumen : Fragment() {
    private lateinit var binding:FragmentResumenBinding

    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentResumenBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel=viewModelCompartido

        binding.entrada.text = viewModelCompartido.tipoReserva.value
        var g: GregorianCalendar = viewModelCompartido.fecha.value as GregorianCalendar
        binding.fecha.text = " "+g.get(GregorianCalendar.YEAR)+"-"+g.get(GregorianCalendar.MONTH)+"-"+g.get(
            GregorianCalendar.DAY_OF_MONTH)

        var ax:Int = viewModelCompartido.numeroAdultos.value!! + viewModelCompartido.numeroNinos.value!!
        binding.personas.text = "Numero de visitantes: "+ax

        binding.botonReservar.setOnClickListener{
            Toast.makeText(context, "Se ha realizado la reserva", Toast.LENGTH_SHORT).show()
            viewModelCompartido.resetearReserva()
            findNavController().navigate(R.id.action_fragmentResumen_to_fragmentInicio)
        }
    }
}