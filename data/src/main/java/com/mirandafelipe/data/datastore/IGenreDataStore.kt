package com.mirandafelipe.data.datastore

import com.mirandafelipe.data.datasource.GenreData
import io.reactivex.Observable

interface IGenreDataStore {
    fun getList(): Observable<List<GenreData>>
}