package com.mirandafelipe.data.datastore

import com.mirandafelipe.domain.model.MoviePresentationModel
import io.reactivex.Observable

interface IFavoriteDataStore {
    fun getList(): List<MoviePresentationModel>
    fun getListObservable(): Observable<List<MoviePresentationModel>>
    fun add(movie: MoviePresentationModel)
    fun deleteByTitle(titleEntity: String)
}