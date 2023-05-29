package com.example.app_ut4_03.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.app_ut4_03.modelo.Critica

@Dao
interface CriticaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCriticas(criticas: List<Critica>)

    @Delete
    suspend fun delete(critica: Critica)

    @Query("SELECT * FROM criticas WHERE pelicula_id =:peliculaId")
    fun getCriticas(peliculaId: Long): LiveData<List<Critica>>
}