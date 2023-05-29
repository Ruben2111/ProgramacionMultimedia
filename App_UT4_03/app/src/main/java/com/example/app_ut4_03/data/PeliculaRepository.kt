package com.example.app_ut4_03.data

import androidx.lifecycle.LiveData
import com.example.app_ut4_03.data.database.CriticaDao
import com.example.app_ut4_03.data.database.PeliculaDao
import com.example.app_ut4_03.modelo.Critica
import com.example.app_ut4_03.modelo.Pelicula
import com.example.app_ut4_03.modelo.PeliculaConCriticas

class PeliculaRepository(private val peliculaDao: PeliculaDao,
                        private val criticaDao: CriticaDao)
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

    fun getCriticas(peliculaId: Long): LiveData<List<Critica>>
    {
        return criticaDao.getCriticas(peliculaId)
    }

    suspend fun insertar(pelicula: PeliculaConCriticas) {
        peliculaDao.insert(pelicula.pelicula)
        criticaDao.insertCriticas(pelicula.criticas)
    }

}