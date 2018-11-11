package au.com.wipro.newsfeed.feedlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import au.com.wipro.newsfeed.domain.FeedEntry


class FeedAdapter : RecyclerView.Adapter<FeedEntryViewHolder>() {

    private val items: MutableList<FeedEntry> = mutableListOf()

    // BUILD ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedEntryViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(FeedEntryViewHolder.layoutId, parent, false)
        return FeedEntryViewHolder(v)
    }

    // BIND VALUES TO THE ViewHolder
    override fun onBindViewHolder(holder: FeedEntryViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private fun getItem(position: Int): FeedEntry {
        return items[position]
    }

    fun setItems(feedEntries: List<FeedEntry>) {
        items.clear()
        items.addAll(feedEntries)
    }
}
