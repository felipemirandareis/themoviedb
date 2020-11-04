package com.mirandafelipe.themoviedb.di

import com.mirandafelipe.domain.model.MoviePresentationModel
import com.mirandafelipe.themoviedb.ui.view.details.DetailsViewModel
import com.mirandafelipe.themoviedb.ui.view.favorites.FavoritesViewModel
import com.mirandafelipe.themoviedb.ui.view.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationModule {
    val module = module {
        viewModel { HomeViewModel(get(), get()) }
        viewModel { (moviePresentationModel: MoviePresentationModel) -> DetailsViewModel(moviePresentationModel) }
        viewModel { FavoritesViewModel(get()) }
    }
}