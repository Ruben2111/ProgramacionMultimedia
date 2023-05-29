package com.example.app_ut4_03.modelo

import androidx.room.Embedded
import androidx.room.Relation
import java.io.Serializable

data class PeliculaConCriticas (
    @Embedded val pelicula: Pelicula,
    @Relation(
            parentColumn = "id",
            entityColumn = "pelicula_id"
    )
    val criticas: List<Critica>

    ) : Serializable