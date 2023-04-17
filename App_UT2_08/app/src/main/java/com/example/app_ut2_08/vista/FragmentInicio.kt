package com.example.app_ut2_08.vista

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_ut2_08.R
import com.example.app_ut2_08.databinding.FragmentInicioBinding
import com.example.app_ut2_08.viewmodel.ProductosViewModel


class FragmentInicio : Fragment() {
    private val viewModel: ProductosViewModel by activityViewModels()
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

        viewModel.listaCategorias.observe(viewLifecycleOwner){
            val adapterCategorias = ArrayAdapter(requireContext(),
                android.R.layout.simple_spinner_item, it)
            binding.spinner.adapter = adapterCategorias
            binding.spinner.setSelection(0,false)
        }

        viewModel.listaProductos.observe(viewLifecycleOwner){
            binding.apply {
                recyclerViewInicio.adapter = ProductosAdapter(viewModel)
                recyclerViewInicio.layoutManager = LinearLayoutManager(context)
                recyclerViewInicio.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }

        viewModel.cargarCategorias()

        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long)
            {
                val categoria = p0?.selectedItem.toString()
                viewModel.cargarProductos(categoria)
                Toast.makeText(context,categoria, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) = Unit
        }

        binding.buttonCesta.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentInicio_to_fragmentCesta)
        }
    }
}