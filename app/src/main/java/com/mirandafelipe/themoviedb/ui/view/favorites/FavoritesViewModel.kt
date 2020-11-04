package com.mirandafelipe.themoviedb.ui.view.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mirandafelipe.domain.FavoriteUseCase
import com.mirandafelipe.domain.model.MoviePresentationModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FavoritesViewModel(
    private val favoriteUseCase: FavoriteUseCase
) : ViewModel() {

    private val favoritesUiStateMutableLiveData = MutableLiveData<FavoritesUiState>()
    val favoritesUiStateLiveData: LiveData<FavoritesUiState> = favoritesUiStateMutableLiveData

    init {
        getFavorites()
    }

    private fun getFavorites() {
        favoriteUseCase.getList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<MoviePresentationModel>> {
                override fun onSubscribe(d: Disposable) {
                    favoritesUiStateMutableLiveData.postValue(FavoritesUiState.Loading)
                }

                override fun onNext(t: List<MoviePresentationModel>) {
                    if (t.isNotEmpty())
                        favoritesUiStateMutableLiveData.postValue(FavoritesUiState.Success(t))
                    else
                        favoritesUiStateMutableLiveData.postValue(FavoritesUiState.Empty)
                }

                override fun onError(e: Throwable) {
                    favoritesUiStateMutableLiveData.postValue(FavoritesUiState.Error)
                }

                override fun onComplete() {

                }

            })
    }
}