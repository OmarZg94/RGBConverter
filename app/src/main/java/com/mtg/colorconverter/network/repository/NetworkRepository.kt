package com.mtg.colorconverter.network.repository

import com.mtg.colorconverter.network.ApiNetwork
import com.mtg.colorconverter.network.ApiService

class NetworkRepository {

    /* */
    val client: ApiService = ApiNetwork.apiService

    /** */
    suspend fun getTimestamp() = client.getTimestamp()
}