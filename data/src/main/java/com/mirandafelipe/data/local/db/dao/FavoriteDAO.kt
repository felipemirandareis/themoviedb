package com.mirandafelipe.data.local.db.dao

import android.content.Context
import com.mirandafelipe.data.local.db.FavoriteDatabaseBuilder
import com.mirandafelipe.data.local.db.entity.MovieEntity
import io.reactivex.Observable

class FavoriteDAO(
    context: Context
) : IFavoriteDAO {

    private val dao = FavoriteDatabaseBuilder.getFavoriteDatabase(context).favoriteDAO()

    override fun add(movie: MovieEntity) {
        dao.add(movie)
    }

    override fun update(movie: MovieEntity) {
        dao.update(movie)
    }

    override fun deleteByTitle(titleEntity: String) {
        dao.deleteByTitle(titleEntity)
    }

    override fun getAll(): List<MovieEntity> {
        return dao.getAll()
    }

    override fun getAllObservable(): Observable<List<MovieEntity>> {
        return dao.getAllObservable()
    }

}