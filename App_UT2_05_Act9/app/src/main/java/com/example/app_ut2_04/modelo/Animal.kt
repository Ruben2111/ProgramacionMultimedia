package com.example.app_ut2_04.modelo

import java.io.Serializable

data class Animal (val nombre:String, val imagenId:Int, var descripcion: String, var votos:Int) :Serializable