package com.mirandafelipe.data.datastore

import com.mirandafelipe.data.local.db.dao.IFavoriteDAO
import com.mirandafelipe.data.mapper.MovieEntityToPresentationModelMapper
import com.mirandafelipe.data.mapper.MoviePresentationModelToEntityMapper
import com.mirandafelipe.domain.model.MoviePresentationModel
import io.reactivex.Observable

class FavoriteDataStore(
    private val favoriteDAO: IFavoriteDAO
) : IFavoriteDataStore {

    private val moviePresentationToEntityModelMapper = MoviePresentationModelToEntityMapper()
    private val movieEntityToPresentationModelMapper = MovieEntityToPresentationModelMapper()

    override fun getList(): List<MoviePresentationModel> {
        return movieEntityToPresentationModelMapper.transform(favoriteDAO.getAll())
    }

    override fun getListObservable(): Observable<List<MoviePresentationModel>> {
        return favoriteDAO.getAllObservable()
            .map { movieEntityToPresentationModelMapper.transform(it) }
    }

    override fun add(movie: MoviePresentationModel) {
        Thread {
            favoriteDAO.add(moviePresentationToEntityModelMapper.transform(movie))
        }.start()
    }

    override fun deleteByTitle(titleEntity: String) {
        Thread {
            favoriteDAO.deleteByTitle(titleEntity)
        }.start()
    }
}