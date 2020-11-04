package com.mirandafelipe.data.di

import com.mirandafelipe.data.datastore.*
import org.koin.dsl.module

object DataStoreModule {
    val module = module {
        factory<IMovieDataStore> { MovieDataStore(get(), get()) }
        factory<IGenreDataStore> { GenreDataStore(get(), get()) }
        factory<IFavoriteDataStore> { FavoriteDataStore(get()) }
    }
}