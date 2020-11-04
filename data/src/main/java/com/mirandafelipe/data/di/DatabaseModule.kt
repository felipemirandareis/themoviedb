package com.mirandafelipe.data.di

import com.mirandafelipe.data.local.db.dao.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DatabaseModule {
    val module = module {
        factory<IMovieDAO> { MovieDAO(androidContext()) }
        factory<IGenreDAO> { GenreDAO(androidContext()) }
        factory<IFavoriteDAO> { FavoriteDAO(androidContext()) }
    }
}