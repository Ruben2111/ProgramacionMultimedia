package com.example.app_ut4_03.data

import androidx.lifecycle.LiveData
import com.example.app_ut4_03.data.database.PeliculaDao
import com.example.app_ut4_03.modelo.Pelicula

class PeliculaRepository(private val peliculaDao: PeliculaDao)
{
    fun get():LiveData<List<Pelicula>> =peliculaDao.getPeliculas()

    fun getFavoritas(): LiveData<List<Pelicula>> = peliculaDao.getFavoritas()

    suspend fun insertar(pelicula:Pelicula){
        peliculaDao.insert(pelicula)
    }

    suspend fun delete(pelicula:Pelicula){
        peliculaDao.deleteById(pelicula.id)
    }

    suspend fun cambiarFavorita(peliculaId:Long){
        peliculaDao.cambiarFavorita(peliculaId)
    }
}