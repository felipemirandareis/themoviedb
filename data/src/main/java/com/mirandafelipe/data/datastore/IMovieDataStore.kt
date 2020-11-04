package com.mirandafelipe.data.datastore

import com.mirandafelipe.data.datasource.MovieData
import io.reactivex.Observable

interface IMovieDataStore {
    fun getList(): Observable<List<MovieData>>
}