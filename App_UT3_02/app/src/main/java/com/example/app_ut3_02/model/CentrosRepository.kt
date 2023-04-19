package com.example.app_ut3_02.model

import com.example.app_ut3_02.data.api.CentrosApi


class CentrosRepository {
    suspend fun get(): List<Centro> = CentrosApi.retrofitService.getCentros()
}