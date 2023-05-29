package com.example.app_ut4_03.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.app_ut4_03.modelo.Pelicula

@Dao
interface PeliculaDao {

    @Query("SELECT * FROM peliculas")
    fun getPeliculas(): LiveData<List<Pelicula>>

    @Query("SELECT * FROM peliculas WHERE favorita =1")
    fun getFavoritas(): LiveData<List<Pelicula>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pelicula: Pelicula)

    @Query("DELETE FROM peliculas WHERE id = :peliculaId")
    suspend fun deleteById(peliculaId: Long)

    @Query("UPDATE peliculas SET favorita = NOT favorita WHERE id=:peliculaId")
    suspend fun cambiarFavorita(peliculaId: Long)

}