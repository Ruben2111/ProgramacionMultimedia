package es.ivanlorenzo.app_ut3_01.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import es.ivanlorenzo.app_ut3_01.R
import es.ivanlorenzo.app_ut3_01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.layoutFragmentHolder) as NavHostFragment
        navController = navHostFragment.navController

        opcionesMenu()
    }



    private fun opcionesMenu() {
            binding.viewBottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.animales -> navController.navigate(R.id.fragmentListaAnimales)
                R.id.favoritos -> navController.navigate(R.id.fragmentFavoritos)
            }
            true
        }
    }

}