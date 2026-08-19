package com.mahshad.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mahshad.database.dao.ResultDao
import com.mahshad.database.model.ResultEntity
import com.mahshad.database.util.Converters

@Database(entities = [ResultEntity::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class MindoraDatabase : RoomDatabase() {
    abstract fun resultDao(): ResultDao
}