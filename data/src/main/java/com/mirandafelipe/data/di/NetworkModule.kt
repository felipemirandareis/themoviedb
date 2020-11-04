package com.mirandafelipe.data.di

import com.mirandafelipe.data.datasource.GenreDataSource
import com.mirandafelipe.data.datasource.IGenreDataSource
import com.mirandafelipe.data.datasource.IMovieDataSource
import com.mirandafelipe.data.datasource.MovieDataSource
import com.mirandafelipe.data.remote.api.TheMovieDBApi
import com.mirandafelipe.data.remote.network.HTTPClient
import org.koin.dsl.module

object NetworkModule {
    val module = module {
        single { HTTPClient() }
        factory { get<HTTPClient>().create(TheMovieDBApi::class) }
        factory<IMovieDataSource> { MovieDataSource(get()) }
        factory<IGenreDataSource> { GenreDataSource(get()) }
    }
}