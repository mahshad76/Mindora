package com.example.data.model

import com.mahshad.database.model.ResultEntity
import com.mahshad.model.MovieInfo
import com.mahshad.network.model.NetworkResult

/**
 * Converts the network model to the local model for persisting
 * by the local data source
 */
fun NetworkResult.asEntity() = ResultEntity(
    adult = this.adult,
    backdropPath = this.backdropPath,
    genreIds = this.genreIds,
    id = this.id,
    originalLanguage = this.originalLanguage,
    originalTitle = this.originalTitle,
    overview = this.overview,
    popularity = this.popularity,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    title = this.title,
    video = this.video,
    voteAverage = this.voteAverage,
    voteCount = this.voteCount
)

/**
 * Converts the local model to the external model for use
 * by layers external to the data layer
 */
fun ResultEntity.asExternalModel() = MovieInfo(
    adult = this.adult,
    backdropPath = this.backdropPath,
    genreIds = this.genreIds,
    id = this.id,
    originalLanguage = this.originalLanguage,
    originalTitle = this.originalTitle,
    overview = this.overview,
    popularity = this.popularity,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    title = this.title,
    video = this.video,
    voteAverage = this.voteAverage,
    voteCount = this.voteCount
)
