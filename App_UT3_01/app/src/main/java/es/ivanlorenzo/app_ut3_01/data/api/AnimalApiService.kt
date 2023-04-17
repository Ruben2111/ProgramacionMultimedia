package es.ivanlorenzo.app_ut3_01.data.api

import es.ivanlorenzo.app_ut3_01.model.Animal
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val URL_BASE =
    "https://aplicaciones.ivanlorenzo.es/pmdm/animales/"

private val retrofit = Retrofit.Builder()
    .baseUrl(URL_BASE)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface AnimalApiService
{
    @GET("animales.json")
    suspend fun getAnimales() : List<Animal>
}

object AnimalesApi {
    val retrofitService: AnimalApiService by lazy { retrofit.create(AnimalApiService::class.java) }
}

