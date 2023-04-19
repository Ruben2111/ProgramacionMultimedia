package com.example.app_ut3_02.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Centro (
    @SerializedName("titulo")
    val nombre:String,
    @SerializedName("correo_electronico")
    val email:String,
    @SerializedName("direccion")
    var direccion:String,
    @SerializedName("horario")
    var horario:String,
    @SerializedName("localizacion")
    var localizacion:String,
    @SerializedName("telefono")
    var telefono:String,
    @SerializedName("web")
    var web:String

    ): Serializable