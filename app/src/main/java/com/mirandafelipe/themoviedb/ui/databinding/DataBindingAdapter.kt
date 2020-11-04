package com.mirandafelipe.themoviedb.ui.databinding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mirandafelipe.themoviedb.R
import com.mirandafelipe.themoviedb.ui.extensions.convertDate

object DataBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:imageUrl")
    public fun setImageUrl(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load("https://image.tmdb.org/t/p/w185$url")
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("bind:date")
    public fun setDate(textView: TextView, date: String) {
        textView.text = date.convertDate("dd/MM/yyyy")
    }
}