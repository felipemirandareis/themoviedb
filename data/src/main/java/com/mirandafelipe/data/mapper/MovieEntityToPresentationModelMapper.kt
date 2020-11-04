package com.mirandafelipe.data.mapper

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mirandafelipe.data.local.db.entity.MovieEntity
import com.mirandafelipe.domain.model.MoviePresentationModel

class MovieEntityToPresentationModelMapper : IMapper<MovieEntity, MoviePresentationModel> {

    @TypeConverter
    fun stringToStringList(value: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, type)
    }

    override fun transform(data: MovieEntity): MoviePresentationModel {
        return MoviePresentationModel(
            title = data.title,
            date = data.date,
            image = data.image,
            overview = data.overview,
            backdrop = data.backdrop,
            genres = stringToStringList(data.genres)
        )
    }
}