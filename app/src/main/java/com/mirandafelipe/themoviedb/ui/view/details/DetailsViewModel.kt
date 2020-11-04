package com.mirandafelipe.themoviedb.ui.view.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mirandafelipe.domain.model.MoviePresentationModel
import com.mirandafelipe.themoviedb.ui.extensions.convertDate

class DetailsViewModel(
    movieModel: MoviePresentationModel
) : ViewModel() {

    private val detailsUiStateMutableLiveData = MutableLiveData<DetailsUiState>()
    val detailsUiStateLiveData: LiveData<DetailsUiState> = detailsUiStateMutableLiveData

    init {
        detailsUiStateMutableLiveData.postValue(
            DetailsUiState.Success(
                MoviePresentationModel(
                    title = movieModel.title,
                    date = movieModel.date.convertDate("dd/MM/yyyy"),
                    image = movieModel.image,
                    backdrop = movieModel.backdrop,
                    overview = movieModel.overview
                )
            )
        )
    }
}