package com.mirandafelipe.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mirandafelipe.data.local.db.dao.IMovieDAO
import com.mirandafelipe.data.local.db.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDAO(): IMovieDAO
}

object MovieDatabaseBuilder {
    private var instance: MovieDatabase? = null

    fun getMovieDatabase(context: Context) = instance ?: build(context)

    private fun build(context: Context): MovieDatabase {
        val dataBaseBuilder = Room.databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java,
            "movie-database"
        ).build()
        instance = dataBaseBuilder
        return dataBaseBuilder
    }
}