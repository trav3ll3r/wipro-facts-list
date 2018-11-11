package au.com.wipro.newsfeed.feedlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import au.com.wipro.newsfeed.R
import au.com.wipro.newsfeed.domain.Feed
import au.com.wipro.newsfeed.feed.ToolbarViewModel
import org.jetbrains.anko.find


class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private lateinit var feedViewModel: FeedViewModel
    private var toolbarViewModel: ToolbarViewModel? = null

    private val recyclerView: RecyclerView? by lazy { view?.find<RecyclerView>(R.id.recycler_view) }
    private lateinit var recyclerAdapter: FeedAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            toolbarViewModel = ViewModelProviders.of(activity!!).get(ToolbarViewModel::class.java)
        }
        feedViewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        initLiveData()
    }

    /* ************ */
    /* INITIALISERS */
    /* ************ */
    private fun initLiveData() {
        feedViewModel.feedLiveData.observe(this, Observer {
            toolbarViewModel?.setToolbarTitle(it.title)
            updateList(it)
        })
        feedViewModel.refresh()
    }

    private fun initRecyclerView() {
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = GridLayoutManager(context, 1)

        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recyclerView?.addItemDecoration(decoration)

        recyclerAdapter = FeedAdapter()
        recyclerView?.adapter = recyclerAdapter
    }

    /* ********* */
    /* REACTIONS */
    /* ********* */
    private fun updateList(feed: Feed) {
        recyclerAdapter.setItems(feed.rows)
        recyclerAdapter.notifyDataSetChanged()
    }

}
