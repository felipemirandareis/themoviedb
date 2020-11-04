package com.mirandafelipe.data.datasource

data class MovieData (
    val title: String,
    val date: String,
    val image: String,
    val genreIds: List<Int>,
    val overview: String,
    val backdrop: String
)