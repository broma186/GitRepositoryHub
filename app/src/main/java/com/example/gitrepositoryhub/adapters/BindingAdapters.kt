package com.example.gitrepositoryhub.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/*
    Used so that Glide can load image urls into the adapter list binding
 */
object BindingAdapters {
    @BindingAdapter("imageFromUrl")
    @JvmStatic
    fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(view.context)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
        }
    }


}

