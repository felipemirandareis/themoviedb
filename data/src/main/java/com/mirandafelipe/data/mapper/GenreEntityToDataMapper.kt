package com.mirandafelipe.data.mapper

import com.mirandafelipe.data.datasource.GenreData
import com.mirandafelipe.data.local.db.entity.GenreEntity

class GenreEntityToDataMapper : IMapper<GenreEntity, GenreData> {
    override fun transform(data: GenreEntity): GenreData {
        return GenreData(
            id = data.id,
            name = data.name
        )
    }
}