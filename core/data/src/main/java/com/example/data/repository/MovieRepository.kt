package com.example.data.repository

import com.mahshad.model.MovieInfo
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    /**
     * Gets the movies as a stream
     */
    fun getMovies(query: String): Flow<Result<List<MovieInfo>>>
}