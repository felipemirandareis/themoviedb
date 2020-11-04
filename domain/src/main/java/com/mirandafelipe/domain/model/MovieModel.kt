package com.mirandafelipe.domain.model

import com.sun.xml.internal.ws.developer.Serialization
import java.io.Serializable

@Serialization
data class MoviePresentationModel(
    val title: String,
    val date: String,
    val image: String,
    var genres: List<String> = listOf(),
    val overview: String,
    val backdrop: String,
    var isFavorite: Boolean = false
) : Serializable

data class MovieModel(
    val title: String,
    val date: String,
    val image: String,
    val genreIds: List<Int> = listOf(),
    val overview: String,
    val backdrop: String,
    var isFavorite: Boolean = false
)

data class GenreModel(
    val id: Int,
    val name: String,
)