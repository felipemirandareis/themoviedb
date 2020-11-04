package com.mirandafelipe.themoviedb.ui.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mirandafelipe.data.datastore.IFavoriteDataStore
import com.mirandafelipe.domain.MovieUseCase
import com.mirandafelipe.domain.model.MoviePresentationModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    private val movieUseCase: MovieUseCase,
    private val favoriteDataStore: IFavoriteDataStore
) : ViewModel() {

    private val homeUiStateMutableLiveData = MutableLiveData<HomeUiState>()
    val homeUiStateLiveData: LiveData<HomeUiState> = homeUiStateMutableLiveData

    init {
        getMovieList()
    }

    private fun getMovieList() {
        movieUseCase.getListWithGenre()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<MoviePresentationModel>> {
                override fun onSubscribe(d: Disposable) {
                    homeUiStateMutableLiveData.postValue(HomeUiState.Loading)
                }

                override fun onNext(t: List<MoviePresentationModel>) {
                    homeUiStateMutableLiveData.postValue(HomeUiState.Success(t))
                }

                override fun onError(e: Throwable) {
                    homeUiStateMutableLiveData.postValue(HomeUiState.Error)
                }

                override fun onComplete() {}
            })
    }

    fun favoriteCLick(movie: MoviePresentationModel) {
        if (movie.isFavorite) deleteFavoriteMovie(movie) else insetFavoriteMovie(movie)
    }

    private fun insetFavoriteMovie(movie: MoviePresentationModel) {
        favoriteDataStore.add(movie)
    }

    private fun deleteFavoriteMovie(movie: MoviePresentationModel) {
        favoriteDataStore.deleteByTitle(movie.title)
    }
}