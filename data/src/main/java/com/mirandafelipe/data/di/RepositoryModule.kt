package com.mirandafelipe.data.di

import com.mirandafelipe.data.repository.MovieRepository
import com.mirandafelipe.domain.repository.IMovieRepository
import org.koin.dsl.module

object RepositoryModule {
    val module = module {
        factory<IMovieRepository> { MovieRepository(get(), get(), get()) }
    }
}