package com.mirandafelipe.domain.repository

import com.mirandafelipe.domain.model.GenreModel
import com.mirandafelipe.domain.model.MovieModel
import com.mirandafelipe.domain.model.MoviePresentationModel
import io.reactivex.Observable

interface IMovieRepository {
    fun getMovie(): Observable<List<MovieModel>>
    fun getGenreIds(): Observable<List<GenreModel>>
    fun getFavorite(): Observable<List<MoviePresentationModel>>
}