package com.mirandafelipe.themoviedb.ui.view.details

import com.mirandafelipe.domain.model.MoviePresentationModel

sealed class DetailsUiState {
    class Success(val movie: MoviePresentationModel) : DetailsUiState()
}