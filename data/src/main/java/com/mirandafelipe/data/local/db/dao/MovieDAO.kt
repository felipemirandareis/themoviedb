package com.mirandafelipe.data.local.db.dao

import android.content.Context
import com.mirandafelipe.data.local.db.MovieDatabaseBuilder
import com.mirandafelipe.data.local.db.entity.MovieEntity

class MovieDAO(
    context: Context
) : IMovieDAO {

    private val dao = MovieDatabaseBuilder.getMovieDatabase(context).movieDAO()

    override fun addAll(vararg movie: MovieEntity) {
        dao.addAll(*movie)
    }

    override fun update(vararg movie: MovieEntity) {
        dao.update(*movie)
    }

    override fun getAll(): List<MovieEntity> {
        return dao.getAll()
    }

    override fun deleteAll() {
        return dao.deleteAll()
    }

}