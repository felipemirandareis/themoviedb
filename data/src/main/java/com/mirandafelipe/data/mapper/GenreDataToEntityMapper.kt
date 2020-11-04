package com.mirandafelipe.data.mapper

import com.mirandafelipe.data.datasource.GenreData
import com.mirandafelipe.data.datasource.MovieData
import com.mirandafelipe.data.local.db.entity.GenreEntity
import com.mirandafelipe.data.local.db.entity.MovieEntity

class GenreDataToEntityMapper : IMapper<GenreData, GenreEntity> {
    override fun transform(data: GenreData): GenreEntity {
        return GenreEntity(
            id = data.id,
            name = data.name
        )
    }
}