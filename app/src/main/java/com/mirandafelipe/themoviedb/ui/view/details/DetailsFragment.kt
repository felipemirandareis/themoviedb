package com.mirandafelipe.themoviedb.ui.view.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mirandafelipe.domain.model.MoviePresentationModel
import com.mirandafelipe.themoviedb.R
import kotlinx.android.synthetic.main.fragment_details.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val movie: MoviePresentationModel by lazy { DetailsFragmentArgs.fromBundle(requireArguments()).moviePresentationModel }
    private val detailsViewModel: DetailsViewModel by viewModel { parametersOf(movie) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsViewModel.detailsUiStateLiveData.observe(viewLifecycleOwner, {
            handlerDetailsUiState(it)
        })
    }

    private fun handlerDetailsUiState(state: DetailsUiState) {
        if (state is DetailsUiState.Success) {
            title.title = state.movie.title
            description.text = state.movie.overview
            date.text = state.movie.date
            setImage(state.movie.backdrop)
        }
    }

    private fun setImage(url: String) {
        Glide.with(requireActivity())
            .load("https://image.tmdb.org/t/p/w185$url")
            .placeholder(R.drawable.ic_launcher_background)
            .into(image)
    }
}