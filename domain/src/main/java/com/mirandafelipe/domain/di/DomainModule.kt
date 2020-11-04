package com.mirandafelipe.domain.di

import com.mirandafelipe.domain.FavoriteUseCase
import com.mirandafelipe.domain.MovieUseCase
import org.koin.dsl.module

object DomainModule {
    val module = module {
        factory { MovieUseCase(get()) }
        factory { FavoriteUseCase(get()) }
    }
}