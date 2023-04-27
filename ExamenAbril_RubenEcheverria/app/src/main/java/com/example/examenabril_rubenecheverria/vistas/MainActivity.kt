package com.example.examenabril_rubenecheverria.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.examenabril_rubenecheverria.R
import com.example.examenabril_rubenecheverria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.layoutFragmentHolder) as NavHostFragment
        navController = navHostFragment.navController

        opcionesMenu()
    }



    private fun opcionesMenu() {
        binding.viewBottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.participantes -> navController.navigate(R.id.fragmentParticipantes)
                R.id.favoritos -> navController.navigate(R.id.fragmentFavoritos)
            }
            true
        }
    }
}