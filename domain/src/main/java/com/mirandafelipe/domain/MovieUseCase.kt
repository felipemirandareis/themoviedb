package com.mirandafelipe.domain

import com.mirandafelipe.domain.model.GenreModel
import com.mirandafelipe.domain.model.MoviePresentationModel
import com.mirandafelipe.domain.repository.IMovieRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MovieUseCase(
    private val movieRepository: IMovieRepository
) {

    fun getListWithGenre(): Observable<List<MoviePresentationModel>> {
        val listGenreModel: List<GenreModel>? = movieRepository.getGenreIds()
            .subscribeOn(Schedulers.io())
            .blockingFirst()

        return movieRepository.getMovie()
            .flatMapIterable { it }
            .map { model ->
                val listGenre: MutableList<String> = mutableListOf()
                model.genreIds.forEach { id ->
                    listGenreModel?.forEach { listGenreIds ->
                        if (id == listGenreIds.id) {
                            listGenre.add(listGenreIds.name)
                        }
                    }
                }
                MoviePresentationModel(
                    model.title,
                    model.date,
                    model.image,
                    listGenre,
                    model.overview,
                    model.backdrop,
                    model.isFavorite
                )
            }
            .toList()
            .toObservable()
    }
}