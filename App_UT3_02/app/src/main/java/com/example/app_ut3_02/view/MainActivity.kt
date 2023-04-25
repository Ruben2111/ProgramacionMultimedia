package com.example.app_ut3_02.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_ut3_02.databinding.ActivityMainBinding
import com.example.app_ut3_02.model.Centro
import com.example.app_ut3_02.viewmodel.CentrosViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val centrosViewModel: CentrosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        centrosViewModel.cargarDatos()

        centrosViewModel.centrosLiveData.observe(this) { centros ->
            with(binding.recyclerViewCentros) {
                adapter = CentroAdapter(centros) { centro -> onClickCentro(centro) }
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }
    }

    private fun onClickCentro(centro: Centro){
        Toast.makeText(this, centro.nombre,Toast.LENGTH_LONG).show()
    }
}