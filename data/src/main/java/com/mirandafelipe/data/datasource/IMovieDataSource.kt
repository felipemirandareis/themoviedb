package com.mirandafelipe.data.datasource

import io.reactivex.Observable

interface IMovieDataSource {
    fun getList(): Observable<List<MovieData>>
}