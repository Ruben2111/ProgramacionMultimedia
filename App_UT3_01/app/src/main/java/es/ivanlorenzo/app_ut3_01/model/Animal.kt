package es.ivanlorenzo.app_ut3_01.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Animal(
    @SerializedName("nombre")
    val nombre:String,
    @SerializedName("imagenURL")
    val imagenURL: String,
    @SerializedName("descripcion")
    val descripcion: String = "",
    @SerializedName("votos")
    var votos: Int = 0
) : Serializable