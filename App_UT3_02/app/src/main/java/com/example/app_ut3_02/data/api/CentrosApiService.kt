package com.example.app_ut3_02.data.api

import com.example.app_ut3_02.model.Centro
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val URL_BASE =
    "https://opendata.gijon.es/"

private val retrofit = Retrofit.Builder()
    .baseUrl(URL_BASE)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface CentrosApiService
{
    @GET("descargar.php?id=754&tipo=JSON")
    suspend fun getCentros() : List<Centro>
}

object CentrosApi {
    val retrofitService: CentrosApiService by lazy { retrofit.create(CentrosApiService::class.java) }
}
