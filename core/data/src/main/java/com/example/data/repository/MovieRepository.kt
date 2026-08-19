package com.example.data.repository

import com.mahshad.model.MovieInfo
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getAllMovies(): Flow<List<MovieInfo>>
}