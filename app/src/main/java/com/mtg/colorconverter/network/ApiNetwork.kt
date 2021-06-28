package com.mtg.colorconverter.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiNetwork {

    /** */
    companion object {
        /* */
        const val URL = "http://worldtimeapi.org/api/"

        /* */
        val apiService: ApiService by lazy {
            Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(ApiService::class.java)
        }
    }
}