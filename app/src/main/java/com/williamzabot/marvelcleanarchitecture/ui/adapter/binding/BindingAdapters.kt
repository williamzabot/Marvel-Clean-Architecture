package com.williamzabot.marvelcleanarchitecture.ui.adapter.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.williamzabot.marvelcleanarchitecture.extensions.urlImage

@BindingAdapter("loadImage")
fun loadImage(view : ImageView, url: String) = view.urlImage(url)