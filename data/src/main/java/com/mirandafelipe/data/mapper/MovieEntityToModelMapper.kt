package com.mirandafelipe.data.mapper

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mirandafelipe.data.local.db.entity.MovieEntity
import com.mirandafelipe.domain.model.MovieModel

class MovieEntityToModelMapper : IMapper<MovieEntity, MovieModel> {

    @TypeConverter
    fun stringToIntList(value: String): List<Int> {
        val type = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(value, type)
    }

    override fun transform(data: MovieEntity): MovieModel {
        return MovieModel(
            title = data.title,
            date = data.date,
            image = data.image,
            overview = data.overview,
            backdrop = data.backdrop
        )
    }
}