package com.mirandafelipe.data.mapper

import com.mirandafelipe.data.datasource.GenreData
import com.mirandafelipe.data.remote.response.Genre

class GenreResponseToDataMapper : IMapper<Genre, GenreData> {
    override fun transform(data: Genre): GenreData {
        return GenreData(
            id = data.id,
            name = data.name
        )
    }
}