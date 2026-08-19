package com.mahshad.database.util

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromGenreIds(value: List<Int>): String {
        return value.joinToString(",")
    }

    @TypeConverter
    fun toGenreIds(value: String): List<Int> {
        if (value.isBlank()) return emptyList()

        return value.split(",").map { it.toInt() }
    }
}