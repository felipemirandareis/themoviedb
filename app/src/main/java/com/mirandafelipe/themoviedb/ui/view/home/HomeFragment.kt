package com.mirandafelipe.themoviedb.ui.view.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mirandafelipe.domain.model.MoviePresentationModel
import com.mirandafelipe.themoviedb.R
import com.mirandafelipe.themoviedb.ui.extensions.animationEntrance
import com.mirandafelipe.themoviedb.ui.extensions.gone
import com.mirandafelipe.themoviedb.ui.extensions.visible
import com.mirandafelipe.themoviedb.ui.view.home.adapter.MovieItemChange
import com.mirandafelipe.themoviedb.ui.view.home.adapter.MovieListAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home), MovieItemChange {

    private val homeViewModel: HomeViewModel by viewModel()
    private val movieListAdapter: MovieListAdapter by lazy { MovieListAdapter(this, requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListMovies()

        homeViewModel.homeUiStateLiveData.observe(viewLifecycleOwner, {
            handlerHomeUiState(it)
        })
    }

    override fun onClickItem(movie: MoviePresentationModel) {
        findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToDetailsFragment(movie))
    }

    override fun onClickFavorite(movie: MoviePresentationModel) {
        homeViewModel.favoriteCLick(movie)
    }

    private fun setupListMovies() {
        recycler_movies.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = movieListAdapter
        }
    }

    private fun handlerHomeUiState(state: HomeUiState) {
        showLoading(state is HomeUiState.Loading)
        showError(state is HomeUiState.Error)

        if (state is HomeUiState.Success) {
            addMovieList(state.list)
        }
    }

    private fun addMovieList(list: List<MoviePresentationModel>) {
        movieListAdapter.addList(list)
        recycler_movies.animationEntrance()
    }

    private fun showLoading(show: Boolean) = if (show) loading.visible else loading.gone
    private fun showError(show: Boolean) = if (show) error.visible else error.gone
}