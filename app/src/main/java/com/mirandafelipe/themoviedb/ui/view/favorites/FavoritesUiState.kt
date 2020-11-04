package com.mirandafelipe.themoviedb.ui.view.favorites

import com.mirandafelipe.domain.model.MoviePresentationModel

sealed class FavoritesUiState {
    class Success(val list: List<MoviePresentationModel>) : FavoritesUiState()
    object Loading : FavoritesUiState()
    object Empty : FavoritesUiState()
    object Error : FavoritesUiState()
}