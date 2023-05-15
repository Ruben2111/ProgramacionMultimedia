package com.example.app_ut4_03.modelo

import androidx.room.PrimaryKey
import java.io.Serializable

data class Pelicula (
    @PrimaryKey(autoGenerate = false)
    val id:Long,
    var titulo:String,
    var anyo:Int,
    var director:String?,
    var puntuacion:Float,
    var imagen:String?,
    var sinopsis:String,
    var favorita:Boolean

    ) :Serializable