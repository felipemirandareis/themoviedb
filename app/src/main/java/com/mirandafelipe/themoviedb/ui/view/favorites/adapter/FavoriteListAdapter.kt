package com.mirandafelipe.themoviedb.ui.view.favorites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mirandafelipe.domain.model.MoviePresentationModel
import com.mirandafelipe.themoviedb.R
import com.mirandafelipe.themoviedb.databinding.ItemFavoriteBinding

class FavoriteListAdapter : RecyclerView.Adapter<FavoriteListAdapter.FavoriteListAdapterViewHolder>() {

    private val list = ArrayList<MoviePresentationModel>()

    fun addList(list: List<MoviePresentationModel>) {
        this.list.clear()
        this.list.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteListAdapterViewHolder {
        return FavoriteListAdapterViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_favorite,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteListAdapterViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

    class FavoriteListAdapterViewHolder(
        private val dataBinding: ItemFavoriteBinding
    ) : RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(movieModel: MoviePresentationModel) {
            dataBinding.movie = movieModel
        }
    }
}