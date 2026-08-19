package com.mahshad.database.di

import android.content.Context
import androidx.room.Room
import com.mahshad.database.MindoraDatabase
import com.mahshad.database.dao.ResultDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val databaseName = "MindoraDatabase"

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideMindoraDatabase(@ApplicationContext context: Context): MindoraDatabase =
        Room.databaseBuilder(
            context = context,
            klass = MindoraDatabase::class.java,
            name = databaseName
        ).build()

    @Provides
    @Singleton
    fun provideResultDao(mindoraDatabase: MindoraDatabase): ResultDao = mindoraDatabase.resultDao()
}