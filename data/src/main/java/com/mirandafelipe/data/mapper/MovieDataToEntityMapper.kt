package com.mirandafelipe.data.mapper

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mirandafelipe.data.datasource.MovieData
import com.mirandafelipe.data.local.db.entity.MovieEntity

class MovieDataToEntityMapper : IMapper<MovieData, MovieEntity> {

    @TypeConverter
    fun listIntToString(value: List<Int>): String {
        val type = object : TypeToken<List<Int>>() {}.type
        return Gson().toJson(value, type)
    }

    override fun transform(data: MovieData): MovieEntity {
        return MovieEntity(
            title = data.title,
            date = data.date,
            image = data.image,
            overview = data.overview,
            backdrop = data.backdrop,
            genres = listIntToString(data.genreIds)
        )
    }
}