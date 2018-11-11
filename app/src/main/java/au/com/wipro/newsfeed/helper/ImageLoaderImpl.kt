package au.com.wipro.newsfeed.helper

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


object ImageLoaderImpl : ImageLoader {

    override fun load(targetView: ImageView, href: String?) {
        val myOptions = RequestOptions()
            .dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.ALL)

        Glide.with(targetView)
            .load(href)
            .apply(myOptions)
            .into(targetView)
    }
}