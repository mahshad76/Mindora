package com.example.data.repository

import com.mahshad.model.MovieInfo
import com.mahshad.network.MindoraNetworkDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryDefault @Inject constructor(
    private val mindoraNetworkDataSource:
    MindoraNetworkDataSource
) : MovieRepository {
    override fun getMovies(query: String): Flow<Result<List<MovieInfo>>> {
        TODO("Not yet implemented")
    }
}