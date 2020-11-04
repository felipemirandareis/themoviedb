package com.mirandafelipe.data.datasource

import io.reactivex.Observable

interface IGenreDataSource {
    fun getList(): Observable<List<GenreData>>
}