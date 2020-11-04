package com.mirandafelipe.data.mapper

import com.mirandafelipe.data.datasource.MovieData
import com.mirandafelipe.data.remote.response.Movie

class MovieResponseToDataMapper : IMapper<Movie, MovieData> {
    override fun transform(data: Movie): MovieData {
        return MovieData(
            title = data.title,
            date = data.date,
            image = data.image,
            genreIds = data.genreIds,
            overview = data.overview,
            backdrop = data.backdrop
        )
    }
}