package com.mahshad.network

import com.mahshad.network.model.NetworkMovies
import retrofit2.Response

interface MindoraNetworkDataSource {
    suspend fun getMovies(query: String): Response<NetworkMovies>
}