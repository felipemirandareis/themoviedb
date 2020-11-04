package com.mirandafelipe.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mirandafelipe.data.local.db.entity.MovieEntity
import io.reactivex.Observable

@Dao
interface IFavoriteDAO {
    @Insert
    fun add(movie: MovieEntity)

    @Update
    fun update(movie: MovieEntity)

    @Query("DELETE FROM movie WHERE title = :titleEntity")
    fun deleteByTitle(titleEntity: String)

    @Query("SELECT * FROM movie")
    fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM movie")
    fun getAllObservable(): Observable<List<MovieEntity>>
}