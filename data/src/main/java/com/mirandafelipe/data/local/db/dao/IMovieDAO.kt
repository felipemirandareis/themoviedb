package com.mirandafelipe.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mirandafelipe.data.local.db.entity.MovieEntity

@Dao
interface IMovieDAO {
    @Insert
    fun addAll(vararg movie: MovieEntity)

    @Update
    fun update(vararg movie: MovieEntity)

    @Query("SELECT * FROM movie")
    fun getAll(): List<MovieEntity>

    @Query("DELETE FROM movie")
    fun deleteAll()
}