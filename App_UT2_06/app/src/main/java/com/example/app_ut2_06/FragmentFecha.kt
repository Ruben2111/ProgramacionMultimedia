package com.example.app_ut2_06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app_ut2_06.databinding.FragmentFechaBinding
import com.example.app_ut2_06.modelo.ReservaZooViewModel
import java.util.*

class FragmentFecha : Fragment() {
    private lateinit var binding: FragmentFechaBinding

    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFechaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModelCompartido
        binding.lifecycleOwner = viewLifecycleOwner

        val hoy = Calendar.getInstance()
        binding.datePicker.init(hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH),
            hoy.get(Calendar.DAY_OF_MONTH)) { _, year, month, day ->
            var fecha=Calendar.getInstance()
            fecha.set(year,month,day)
            viewModelCompartido.setFecha(fecha)
        }

        binding.botonSiguiente.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentFecha_to_fragmentResumen)
        }
    }
}