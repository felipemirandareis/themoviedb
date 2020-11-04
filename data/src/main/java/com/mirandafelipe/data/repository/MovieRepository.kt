package com.mirandafelipe.data.repository

import com.mirandafelipe.data.datastore.IFavoriteDataStore
import com.mirandafelipe.data.datastore.IGenreDataStore
import com.mirandafelipe.data.datastore.IMovieDataStore
import com.mirandafelipe.data.mapper.GenreDataToModelMapper
import com.mirandafelipe.data.mapper.MovieDataToModelMapper
import com.mirandafelipe.domain.model.GenreModel
import com.mirandafelipe.domain.model.MovieModel
import com.mirandafelipe.domain.model.MoviePresentationModel
import com.mirandafelipe.domain.repository.IMovieRepository
import io.reactivex.Observable

class MovieRepository(
    private val movieDataStore: IMovieDataStore,
    private val genreDataStore: IGenreDataStore,
    private val favoriteDataStore: IFavoriteDataStore
) : IMovieRepository {

    private val movieDataToModelMapper = MovieDataToModelMapper()
    private val genreDataToModelMapper = GenreDataToModelMapper()

    override fun getMovie(): Observable<List<MovieModel>> {
        return movieDataStore.getList()
            .flatMapIterable { movieDataToModelMapper.transform(it) }
            .map { data ->
                favoriteDataStore.getList().forEach { favorite ->
                    if (data.title == favorite.title)
                        data.isFavorite = true
                }
                data
            }
            .toList()
            .toObservable()
    }

    override fun getGenreIds(): Observable<List<GenreModel>> {
        return genreDataStore.getList()
            .map { genreDataToModelMapper.transform(it) }
    }

    override fun getFavorite(): Observable<List<MoviePresentationModel>> {
        return favoriteDataStore.getListObservable()
    }
}