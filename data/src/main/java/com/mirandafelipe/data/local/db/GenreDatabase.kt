package com.mirandafelipe.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mirandafelipe.data.local.db.dao.IGenreDAO
import com.mirandafelipe.data.local.db.entity.GenreEntity

@Database(entities = [GenreEntity::class], version = 1)
abstract class GenreDatabase : RoomDatabase() {
    abstract fun genreDAO(): IGenreDAO
}

object GenreDatabaseBuilder {
    private var instance: GenreDatabase? = null

    fun getGenreDatabase(context: Context) = instance ?: build(context)

    private fun build(context: Context): GenreDatabase {
        val dataBaseBuilder = Room.databaseBuilder(
            context.applicationContext,
            GenreDatabase::class.java,
            "genre-database"
        ).build()
        instance = dataBaseBuilder
        return dataBaseBuilder
    }
}