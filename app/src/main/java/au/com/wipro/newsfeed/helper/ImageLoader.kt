package au.com.wipro.newsfeed.helper

import android.widget.ImageView

interface ImageLoader {

    fun load(targetView: ImageView, href: String?)
}