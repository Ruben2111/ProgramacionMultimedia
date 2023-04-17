package com.example.app_ut2_08.vista

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_ut2_08.databinding.FragmentCestaBinding
import com.example.app_ut2_08.viewmodel.ProductosViewModel


class FragmentCesta : Fragment() {
    private val viewModel: ProductosViewModel by activityViewModels()
    private lateinit var binding:FragmentCestaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCestaBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerViewCesta.adapter = CestaAdapter(viewModel)
            recyclerViewCesta.layoutManager = GridLayoutManager(context,2)
        }

        binding.textViewCestaCarro.text= ""+viewModel.listaCompra.value?.size+" productos en la cesta"
    }
}