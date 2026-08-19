package com.mahshad.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.mahshad.database.model.ResultEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultDao {
    @Query("SELECT * FROM result")
    fun getResult(): Flow<List<ResultEntity>>
}