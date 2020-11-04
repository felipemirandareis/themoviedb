package com.mirandafelipe.data.mapper

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mirandafelipe.data.datasource.MovieData
import com.mirandafelipe.data.local.db.entity.MovieEntity

class MovieEntityToDataMapper : IMapper<MovieEntity, MovieData> {

    @TypeConverter
    fun stringToIntList(value: String): List<Int> {
        val type = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(value, type)
    }

    override fun transform(data: MovieEntity): MovieData {
        return MovieData(
            title = data.title,
            date = data.date,
            image = data.image,
            overview = data.overview,
            backdrop = data.backdrop,
            genreIds = stringToIntList(data.genres)
        )
    }
}