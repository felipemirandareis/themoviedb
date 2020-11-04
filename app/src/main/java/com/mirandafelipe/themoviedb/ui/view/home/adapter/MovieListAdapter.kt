package com.mirandafelipe.themoviedb.ui.view.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mirandafelipe.domain.model.MoviePresentationModel
import com.mirandafelipe.themoviedb.R
import com.mirandafelipe.themoviedb.databinding.ItemMovieBinding
import com.mirandafelipe.themoviedb.ui.extensions.onSingleClick
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieListAdapter(
    private val movieItemChange: MovieItemChange,
    private val context: Context
) : RecyclerView.Adapter<MovieListAdapter.MovieListAdapterViewHolder>() {

    private val list = ArrayList<MoviePresentationModel>()

    fun addList(list: List<MoviePresentationModel>) {
        this.list.clear()
        this.list.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapterViewHolder {
        return MovieListAdapterViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieListAdapterViewHolder, position: Int) {
        val item = list[position]

        holder.bind(item)

        holder.itemView.image.onSingleClick {
            movieItemChange.onClickItem(item)
        }
        holder.itemView.favorite.onSingleClick {
            movieItemChange.onClickFavorite(item)

            if (item.isFavorite) {
                item.isFavorite = false
                holder.itemView.favorite.setImageResource(R.drawable.ic_favorite_border_purple_18dp)
                holder.itemView.favorite.background = ContextCompat.getDrawable(context, R.drawable.shape_circle_solid_white)
            } else {
                item.isFavorite = true
                holder.itemView.favorite.setImageResource(R.drawable.ic_favorite_border_white_18dp)
                holder.itemView.favorite.background = ContextCompat.getDrawable(context, R.drawable.shape_circle_solid_red)
            }
        }

    }

    override fun getItemCount(): Int = list.size

    class MovieListAdapterViewHolder(
        private val dataBinding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(movieModel: MoviePresentationModel) {
            dataBinding.movie = movieModel
        }
    }
}