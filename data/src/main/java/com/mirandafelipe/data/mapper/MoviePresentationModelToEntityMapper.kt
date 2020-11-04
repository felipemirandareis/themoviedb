package com.mirandafelipe.data.mapper

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mirandafelipe.data.local.db.entity.MovieEntity
import com.mirandafelipe.domain.model.MoviePresentationModel

class MoviePresentationModelToEntityMapper : IMapper<MoviePresentationModel, MovieEntity> {

    @TypeConverter
    fun listStringToString(value: List<String>): String {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().toJson(value, type)
    }

    override fun transform(data: MoviePresentationModel): MovieEntity {
        return MovieEntity(
            title = data.title,
            date = data.date,
            image = data.image,
            overview = data.overview,
            backdrop = data.backdrop,
            genres = listStringToString(data.genres)
        )
    }
}