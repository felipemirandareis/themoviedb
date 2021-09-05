package com.mirandafelipe.domain

import com.mirandafelipe.domain.model.MovieGenreModel
import com.mirandafelipe.domain.model.MoviePresentationModel
import com.mirandafelipe.domain.repository.IMovieRepository
import io.reactivex.Observable

class MovieUseCase(
    private val movieRepository: IMovieRepository
) {

    fun getListWithGenre(): Observable<List<MoviePresentationModel>> {
        val genreObservable = movieRepository.getGenreIds()
        val movieObservable = movieRepository.getMovie()

        return Observable.zip(movieObservable, genreObservable, { movies, genres ->
            MovieGenreModel(movies, genres)
        })
            .map { movieGenreModel ->
                val movies = movieGenreModel.movies
                val genres = movieGenreModel.genres

                val listGenreNames: MutableList<String> = mutableListOf()
                val moviePresentationList: MutableList<MoviePresentationModel> = mutableListOf()

                movies.forEach { movie ->
                    movie.genreIds.forEach { id ->
                        genres.forEach { listGenreIds ->
                            if (id == listGenreIds.id) {
                                listGenreNames.add(listGenreIds.name)
                            }
                        }
                    }
                    moviePresentationList.add(
                        MoviePresentationModel(
                            movie.title,
                            movie.date,
                            movie.image,
                            listGenreNames,
                            movie.overview,
                            movie.backdrop,
                            movie.isFavorite
                        )
                    )
                }
                moviePresentationList
            }
    }
}