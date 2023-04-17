package es.ivanlorenzo.app_ut3_01.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import es.ivanlorenzo.app_ut3_01.databinding.FragmentListaAnimalesBinding
import es.ivanlorenzo.app_ut3_01.model.Animal
import es.ivanlorenzo.app_ut3_01.viewmodel.AnimalViewModel

class FragmentListaAnimales : Fragment()
{
    private lateinit var binding: FragmentListaAnimalesBinding
    private lateinit var navController: NavController
    private val animalViewModel: AnimalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        binding = FragmentListaAnimalesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        animalViewModel.cargarDatos()

        animalViewModel.animalesLiveData.observe(viewLifecycleOwner) { animales ->
            with (binding.recyclerViewAnimales){
                adapter = AnimalAdapter(animales){ animal -> onClickAnimal(animal)}
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }



        animalViewModel.estaCargandoLiveData.observe(viewLifecycleOwner){estaCargando ->
            binding.progressBarCargaAnimales.isVisible = estaCargando
            binding.recyclerViewAnimales.isVisible = !estaCargando
        }


    }

    private fun onClickAnimal(animal: Animal)
    {
        val accion = FragmentListaAnimalesDirections.actionFragmentListaAnimalesToFragmentDetalleAnimal(animal = animal)
        navController.navigate(accion)
    }





}