package au.com.wipro.newsfeed.feedlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import au.com.wipro.newsfeed.R
import au.com.wipro.newsfeed.domain.Feed
import au.com.wipro.newsfeed.feed.ToolbarViewModel
import dagger.android.support.AndroidSupportInjection
import org.jetbrains.anko.find
import javax.inject.Inject


class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val feedViewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, factory).get(FeedViewModel::class.java)
    }

    private val toolbarViewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(activity!!, factory).get(ToolbarViewModel::class.java)
    }

    private val swipeRefreshLayout: SwipeRefreshLayout? by lazy { view?.find<SwipeRefreshLayout>(R.id.swipe_refresh) }
    private val recyclerView: RecyclerView? by lazy { view?.find<RecyclerView>(R.id.recycler_view) }
    private lateinit var recyclerAdapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSwipeRefresh()
        initRecyclerView()
        initLiveData()
    }

    /* ************ */
    /* INITIALISERS */
    /* ************ */
    private fun initLiveData() {
        feedViewModel.feedLiveData.observe(this, Observer {
            toolbarViewModel.setToolbarTitle(it.title)
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

    /**
     * Sets up a SwipeRefreshLayout.OnRefreshListener that is invoked when the user
     * performs a swipe-to-refresh gesture.
     */
    private fun initSwipeRefresh() {
        swipeRefreshLayout?.setOnRefreshListener { refreshData() }
    }

    /* ********* */
    /* REACTIONS */
    /* ********* */
    private fun updateList(feed: Feed) {
        recyclerAdapter.setItems(feed.rows)
        recyclerAdapter.notifyDataSetChanged()
        swipeRefreshLayout?.isRefreshing = false
    }

    private fun refreshData() {
        swipeRefreshLayout?.isRefreshing = true
        feedViewModel.refresh()
    }
}
