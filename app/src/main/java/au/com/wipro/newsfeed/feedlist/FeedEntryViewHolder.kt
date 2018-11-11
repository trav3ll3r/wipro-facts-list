package au.com.wipro.newsfeed.feedlist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import au.com.wipro.newsfeed.R
import au.com.wipro.newsfeed.domain.FeedEntry
import au.com.wipro.newsfeed.helper.ImageLoader
import au.com.wipro.newsfeed.helper.ImageLoaderImpl
import org.jetbrains.anko.find


class FeedEntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        const val layoutId = R.layout.list_item_feed_entry
    }

    private val imageLoader: ImageLoader = ImageLoaderImpl

    private val title: TextView = itemView.find(R.id.title)
    private val description: TextView = itemView.find(R.id.description)
    private val image: ImageView = itemView.find(R.id.image)

    fun bindView(feedEntry: FeedEntry) {
        title.text = feedEntry.title
        description.text = feedEntry.description
        imageLoader.load(image, feedEntry.imageHref)
    }
}