package es.ivanlorenzo.app_ut3_01.model

import es.ivanlorenzo.app_ut3_01.data.api.AnimalesApi

class AnimalRepository
{
    suspend fun get(): List<Animal> = AnimalesApi.retrofitService.getAnimales()
}