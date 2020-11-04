package com.mirandafelipe.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mirandafelipe.data.local.db.entity.GenreEntity

@Dao
interface IGenreDAO {
    @Insert
    fun addAll(vararg genre: GenreEntity)

    @Query("SELECT * FROM genre")
    fun getAll(): List<GenreEntity>

    @Query("DELETE FROM genre")
    fun deleteAll()
}