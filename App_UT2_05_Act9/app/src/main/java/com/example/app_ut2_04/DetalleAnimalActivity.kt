package com.example.app_ut2_04

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app_ut2_04.databinding.ActivityDetalleAnimalBinding
import com.example.app_ut2_04.modelo.Animal

class DetalleAnimalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleAnimalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animal = intent.extras?.get("animal") as Animal

        binding.textNombreDetalle.text=animal.nombre
        binding.textDescripcionDetalle.text=animal.descripcion
        binding.imagenDetalle.setImageResource(animal.imagenId)

        binding.buttonPositivo.setOnClickListener {
            crearIntentAMain(animal, 1)
        }
        binding.buttonNegativo.setOnClickListener {
            crearIntentAMain(animal, -1)
        }

    }

    fun crearIntentAMain(animal: Animal, voto: Int)
    {
        val intentDevuelto = Intent()
        intentDevuelto.putExtra("voto", voto)
        intentDevuelto.putExtra("animal", animal.nombre)
        setResult(RESULT_OK, intentDevuelto)
        finish()
    }
}