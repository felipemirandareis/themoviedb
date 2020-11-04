package com.mirandafelipe.themoviedb.ui.view.home

import com.mirandafelipe.domain.model.MoviePresentationModel

sealed class HomeUiState {
    class Success(val list: List<MoviePresentationModel>) : HomeUiState()
    object Loading : HomeUiState()
    object Error : HomeUiState()
}