package com.example.app_ut4_03.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "peliculas")
data class Pelicula (
    @PrimaryKey(autoGenerate = false)
    val id:Long,
    var titulo:String,
    var anyo:Int,
    var director:String?,
    @ColumnInfo(name="puntos")
    var puntuacion:Float,
    var imagen:String?,
    var sinopsis:String,
    var favorita:Boolean
    ) :Serializable