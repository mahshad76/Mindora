package com.example.data.model

import com.mahshad.network.model.NetworkMovies

data class MoviesEntity(
    val page: Int,
    val results: List<ResultEntity>,
    val totalPages: Int,
    val totalResults: Int
)

fun NetworkMovies.toEntity() = MoviesEntity(
    page = this.page,
    results = this.results.map { it.toEntity() },
    totalPages = this.totalPages,
    totalResults = this.totalResults
)


