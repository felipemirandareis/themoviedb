package com.mirandafelipe.themoviedb.ui.view.home.adapter

import com.mirandafelipe.domain.model.MoviePresentationModel

interface MovieItemChange {
    fun onClickItem(movie: MoviePresentationModel)
    fun onClickFavorite(movie: MoviePresentationModel)
}