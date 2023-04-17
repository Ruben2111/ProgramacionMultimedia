package es.ivanlorenzo.app_ut3_01.view

import android.graphics.Color
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import coil.load
import es.ivanlorenzo.app_ut3_01.R
import es.ivanlorenzo.app_ut3_01.databinding.FragmentDetalleAnimalBinding
import es.ivanlorenzo.app_ut3_01.model.Animal
import es.ivanlorenzo.app_ut3_01.viewmodel.AnimalViewModel

class FragmentDetalleAnimal : Fragment() {

    private lateinit var binding: FragmentDetalleAnimalBinding
    private val animalViewModel: AnimalViewModel by activityViewModels()

    private lateinit var animal: Animal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            animal = it.get("animal") as Animal
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetalleAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.textViewNombre.text = animal.nombre
        binding.textViewDescripcion.text = animal.descripcion
        binding.textViewDescripcion.movementMethod = ScrollingMovementMethod()

        binding.imageViewAnimal.load("https://aplicaciones.ivanlorenzo.es/pmdm/animales/${animal.imagenURL}.png")

            val resID = resources.getIdentifier(animal.imagenURL, "drawable", context?.packageName )
        binding.imageViewAnimal.setImageResource(resID)

        binding.imageViewFavorito.setOnClickListener {
            binding.imageViewFavorito.setColorFilter(Color.parseColor("#FFDAA95E"))
        }

        binding.botonPositivo.setOnClickListener {
            animalViewModel.cambiarVoto(animal.nombre, 1)
            view.findNavController().navigate(R.id.fragmentListaAnimales)
        }

        binding.botonNegativo.setOnClickListener {
            animalViewModel.cambiarVoto(animal.nombre, -1)
            view.findNavController().navigate(R.id.fragmentListaAnimales)
        }
    }


}