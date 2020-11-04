package com.mirandafelipe.data.local.db.dao

import android.content.Context
import com.mirandafelipe.data.local.db.GenreDatabaseBuilder
import com.mirandafelipe.data.local.db.entity.GenreEntity

class GenreDAO(
    context: Context
) : IGenreDAO {

    private val dao = GenreDatabaseBuilder.getGenreDatabase(context).genreDAO()

    override fun addAll(vararg genre: GenreEntity) {
        dao.addAll(*genre)
    }

    override fun getAll(): List<GenreEntity> {
        return dao.getAll()
    }

    override fun deleteAll() {
        return dao.deleteAll()
    }
}