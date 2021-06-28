package com.mtg.colorconverter.network

import com.mtg.colorconverter.network.ApiService.URL.GET_TIMESTAMP
import com.mtg.colorconverter.network.dto.TimestampDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(GET_TIMESTAMP)
    suspend fun getTimestamp(): Response<TimestampDto>

    object URL {
        /* */
        const val GET_TIMESTAMP = "timezone/America/Mexico_City"
    }
}