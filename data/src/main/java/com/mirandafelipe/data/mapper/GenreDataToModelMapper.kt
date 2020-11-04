package com.mirandafelipe.data.mapper

import com.mirandafelipe.data.datasource.GenreData
import com.mirandafelipe.domain.model.GenreModel

class GenreDataToModelMapper : IMapper<GenreData, GenreModel> {
    override fun transform(data: GenreData): GenreModel {
        return GenreModel(
            id = data.id,
            name = data.name
        )
    }
}