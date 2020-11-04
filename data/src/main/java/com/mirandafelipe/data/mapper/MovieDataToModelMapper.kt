package com.mirandafelipe.data.mapper

import com.mirandafelipe.data.datasource.MovieData
import com.mirandafelipe.domain.model.MovieModel

class MovieDataToModelMapper : IMapper<MovieData, MovieModel> {
    override fun transform(data: MovieData): MovieModel {
        return MovieModel(
            title = data.title,
            date = data.date,
            image = data.image,
            genreIds = data.genreIds,
            overview = data.overview,
            backdrop = data.backdrop
        )
    }
}