package com.mahshad.network.retrofit

import com.mahshad.network.BuildConfig
import com.mahshad.network.MindoraNetworkDataSource
import com.mahshad.network.model.NetworkMovies
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private const val TMDB_BASE_URL = BuildConfig.TMDB_BASE_URL

private interface RetrofitMindoraNetworkApi {
    @GET
    suspend fun getMovies(
        @Query("append_to_response") appendToResponse: String,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Header("Authorization") authorization: String = BuildConfig.TMDB_ACCESS_TOKEN
    ): Response<NetworkMovies>
}

@Singleton
internal class RetrofitMindoraNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: dagger.Lazy<Call.Factory>
) : MindoraNetworkDataSource {
    private val networkApi = Retrofit.Builder()
        .baseUrl(TMDB_BASE_URL)
        .callFactory { okhttpCallFactory.get().newCall(it) }
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(MindoraNetworkDataSource::class.java)

    override suspend fun getMovies(query: String): Response<NetworkMovies> = networkApi.getMovies(query)
}