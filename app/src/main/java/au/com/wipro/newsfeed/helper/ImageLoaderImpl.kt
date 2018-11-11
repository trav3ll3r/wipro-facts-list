package au.com.wipro.newsfeed.helper

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import au.com.wipro.newsfeed.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


object ImageLoaderImpl : ImageLoader {

    override fun load(target: ImageView, href: String?) {
        val myOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background) // SHOWN WHILE LOADING
            .fallback(ColorDrawable(Color.TRANSPARENT)) // SHOWN IF LOADING RESOURCE IS NULL
            .error(ColorDrawable(Color.TRANSPARENT))   // SHOWN IF LOADING RESOURCE ERRORS

        Glide.with(target)
            .load(href)
            .apply(myOptions)
            .into(target)
    }
}