package com.mirandafelipe.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mirandafelipe.data.local.db.dao.IFavoriteDAO
import com.mirandafelipe.data.local.db.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun favoriteDAO(): IFavoriteDAO
}

object FavoriteDatabaseBuilder {
    private var instance: FavoriteDatabase? = null

    fun getFavoriteDatabase(context: Context) = instance ?: build(context)

    private fun build(context: Context): FavoriteDatabase {
        val dataBaseBuilder = Room.databaseBuilder(
            context.applicationContext,
            FavoriteDatabase::class.java,
            "favorite-database"
        ).build()
        instance = dataBaseBuilder
        return dataBaseBuilder
    }
}