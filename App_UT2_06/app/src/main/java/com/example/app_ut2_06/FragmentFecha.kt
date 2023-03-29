package com.example.app_ut2_06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.app_ut2_06.databinding.FragmentFechaBinding
import java.util.*

class FragmentFecha : Fragment() {
    private lateinit var binding: FragmentFechaBinding

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
        val hoy = Calendar.getInstance()
        binding.datePicker.init(hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH),
            hoy.get(Calendar.DAY_OF_MONTH)) { view, year, month, day ->
            val mensaje = "Fecha: $day/${month+1}/$year"
            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
        }
    }
}