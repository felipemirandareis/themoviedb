package com.mirandafelipe.themoviedb.ui.view.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirandafelipe.domain.model.MoviePresentationModel
import com.mirandafelipe.themoviedb.R
import com.mirandafelipe.themoviedb.ui.extensions.animationEntrance
import com.mirandafelipe.themoviedb.ui.extensions.gone
import com.mirandafelipe.themoviedb.ui.extensions.visible
import com.mirandafelipe.themoviedb.ui.view.favorites.adapter.FavoriteListAdapter
import kotlinx.android.synthetic.main.fragment_favorites.*
import org.koin.android.viewmodel.ext.android.viewModel

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private val favoritesViewModel: FavoritesViewModel by viewModel()
    private val favoriteListAdapter = FavoriteListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListFavorites()

        favoritesViewModel.favoritesUiStateLiveData.observe(viewLifecycleOwner, {
            handlerFavoritesUiState(it)
        })
    }

    private fun handlerFavoritesUiState(state: FavoritesUiState) {
        showLoading(state is FavoritesUiState.Loading)
        showError(state is FavoritesUiState.Error)
        showEmpty(state is FavoritesUiState.Empty)

        if (state is FavoritesUiState.Success) {
            addFavoriteList(state.list)
        }
    }

    private fun addFavoriteList(list: List<MoviePresentationModel>) {
        favoriteListAdapter.addList(list)
        recycler_favorites.animationEntrance()
    }

    private fun setupListFavorites() {
        recycler_favorites.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = favoriteListAdapter
        }
    }

    private fun showLoading(show: Boolean) = if (show) loading.visible else loading.gone
    private fun showError(show: Boolean) = if (show) error.visible else error.gone
    private fun showEmpty(show: Boolean) = if (show) text_empty.visible else text_empty.gone
}