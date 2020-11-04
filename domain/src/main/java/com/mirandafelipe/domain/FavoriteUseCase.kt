package com.mirandafelipe.domain

import com.mirandafelipe.domain.model.MoviePresentationModel
import com.mirandafelipe.domain.repository.IMovieRepository
import io.reactivex.Observable

class FavoriteUseCase(
    private val movieRepository: IMovieRepository
) {

    fun getList(): Observable<List<MoviePresentationModel>> {
        return movieRepository.getFavorite()
    }
}