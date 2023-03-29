package com.example.app_ut2_04

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut2_04.databinding.ActivityDetalleAnimalBinding
import com.example.app_ut2_04.databinding.ActivityMainBinding
import com.example.app_ut2_04.modelo.Animal
import com.example.app_ut2_04.modelo.AnimalAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    @SuppressLint("NotifyDataSetChanged")
    private val segundaActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if(it.resultCode == Activity.RESULT_OK){
                val voto = it.data?.getIntExtra("voto", 0)?:0
                val nombre = it.data?.getStringExtra("animal")?:""
                (recyclerView.adapter as AnimalAdapter).cambiarVoto(nombre, voto)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        }

    private lateinit var recyclerView: RecyclerView

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        recyclerView.adapter = AnimalAdapter(){ animal -> onClickAnimal(animal)}
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(this,
            DividerItemDecoration.VERTICAL)
        )

        binding.botonFlotante.setOnClickListener {
            dialogoNuevoAnimal()
        }
    }

    private fun dialogoNuevoAnimal()
    {
        val inputEditTextField = EditText(this)

        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle("Nuevo animal")
            .setMessage("Introduce el nombre de un nuevo animal")
            .setView(inputEditTextField)
            .setPositiveButton("Añadir") { _, _ ->
                val nuevoAnimal = inputEditTextField .text.toString()
                (recyclerView.adapter as AnimalAdapter).addAnimal(nuevoAnimal)
            }
            .setNegativeButton("Cancelar", null)
            .create()


        dialog.show()
    }


    private fun onClickAnimal(animal: Animal)
    {
        //Toast.makeText(this, animal.descripcion, Toast.LENGTH_LONG).show()
        val intent = Intent(applicationContext, DetalleAnimalActivity::class.java)
        intent.putExtra("animal", animal)
        //startActivity(intent)
        segundaActivityLauncher.launch(intent)
    }
}