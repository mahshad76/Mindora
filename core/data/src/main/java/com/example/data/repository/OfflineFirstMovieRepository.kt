package com.example.data.repository

import com.example.common.Dispatcher
import com.example.common.MindoraDispatchers
import com.example.data.model.asExternalModel
import com.mahshad.database.dao.ResultDao
import com.mahshad.model.MovieInfo
import com.mahshad.network.MindoraNetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstMovieRepository @Inject constructor(
    private val mindoraNetworkDataSource: MindoraNetworkDataSource,
    private val resultDao: ResultDao,
    @Dispatcher(MindoraDispatchers.DEFAULT) private val defaultDispatcher: CoroutineDispatcher
) : MovieRepository {
    override fun getAllMovies(): Flow<List<MovieInfo>> =
        resultDao
            .getResult()
            .map { resultEntities ->
                resultEntities.map { resultEntity ->
                    resultEntity.asExternalModel()
                }
            }
            .flowOn(defaultDispatcher)
}