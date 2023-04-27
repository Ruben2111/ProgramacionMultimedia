package com.example.examenabril_rubenecheverria.modelo

import java.io.Serializable

data class Participante (val nombre:String, val cancion:String,
                         val imagen:Int, var puntosJurado:Int,
                         var puntosDemoscopio:Int, var puntosTelevoto:Int,
                         var favorito:Boolean
                         ): Serializable