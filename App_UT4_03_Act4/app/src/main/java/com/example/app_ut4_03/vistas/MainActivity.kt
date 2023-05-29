package com.example.app_ut4_03.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.app_ut4_03.R
import com.example.app_ut4_03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.layoutFragmentHolder) as NavHostFragment
        navController = navHostFragment.navController

        opcionesMenu()

        binding.apply {
            toggle=ActionBarDrawerToggle(this@MainActivity,drawerLayout, R.string.mejor_pelis,R.string.mejor_pelis)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            navView.setCheckedItem(R.id.listaPelis)
            navView.setNavigationItemSelectedListener {
                when (it.itemId){
                    R.id.listaPelis->{ navController.navigate(R.id.fragmentListaPeliculas) }
                    R.id.inserPelis->{ navController.navigate(R.id.fragmentNuevaPelicula) }
                    //R.id.info->{ navController.navigate(R.id.fragmentDetalle) }
                }
                drawerLayout.closeDrawer(GravityCompat.START)
                true
            }
        }
    }

    private fun opcionesMenu() {
        binding.viewBottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.peliculas -> navController.navigate(R.id.fragmentListaPeliculas)
                R.id.favoritas -> navController.navigate(R.id.fragmentListaFavoritas)
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}