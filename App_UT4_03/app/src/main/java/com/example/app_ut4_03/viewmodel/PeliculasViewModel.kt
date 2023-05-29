package com.example.app_ut4_03.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.app_ut4_03.data.PeliculaRepository
import com.example.app_ut4_03.data.database.PeliculaDatabase
import com.example.app_ut4_03.modelo.Critica
import com.example.app_ut4_03.modelo.Pelicula
import com.example.app_ut4_03.modelo.PeliculaConCriticas
import kotlinx.coroutines.launch

class PeliculasViewModel (context: Context): ViewModel()
{
    private val repositorio: PeliculaRepository
    val peliculas: LiveData<List<Pelicula>>
    val peliculasFavoritas: LiveData<List<Pelicula>>

    init{
        val peliculaDao= PeliculaDatabase.getDatabase(context).peliculaDao()
        val criticaDao= PeliculaDatabase.getDatabase(context).criticaDao()
        repositorio=PeliculaRepository(peliculaDao,criticaDao)
        peliculas=repositorio.get()
        peliculasFavoritas=repositorio.getFavoritas()
    }

    fun insertarPelicula(pelicula:Pelicula){
        viewModelScope.launch {
            repositorio.insertar(pelicula)
        }
    }

    fun borrarPelicula(pelicula:Pelicula){
        viewModelScope.launch {
            repositorio.delete(pelicula)
        }
    }

    fun cambiarFavorita(peliculaId:Long){
        viewModelScope.launch {
            repositorio.cambiarFavorita(peliculaId)
        }
    }

    fun getCriticas(peliculaId: Long): LiveData<List<Critica>>
    {
        return repositorio.getCriticas(peliculaId)
    }
    fun insertarPeliculaConCriticas(pelicula: PeliculaConCriticas)
    {
        viewModelScope.launch {
            repositorio.insertar(pelicula)
        }
    }



    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val contexto = (this[APPLICATION_KEY] as Context)
                PeliculasViewModel(
                    context = contexto
                )
            }
        }
    }
}