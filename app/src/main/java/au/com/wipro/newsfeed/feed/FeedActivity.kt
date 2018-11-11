package au.com.wipro.newsfeed.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import au.com.wipro.newsfeed.R
import au.com.wipro.newsfeed.feedlist.FeedFragment
import dagger.android.AndroidInjection
import org.jetbrains.anko.find
import javax.inject.Inject


class FeedActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val toolbarViewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, factory).get(ToolbarViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModels()
        showFeed()
    }

    /* ************ */
    /* INITIALISERS */
    /* ************ */
    private fun initViewModels() {
        //toolbarViewModel = ViewModelProviders.of(this).get(ToolbarViewModel::class.java)
        toolbarViewModel.toolbarLiveData.observe(this, Observer {
            setToolbarTitle(it)
        })
    }

    /* ******* */
    /* ACTIONS */
    /* ******* */
    private fun showFeed() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, FeedFragment.newInstance())
            .commit()
    }

    /* ********* */
    /* REACTIONS */
    /* ********* */
    private fun setToolbarTitle(title: String) {
        find<Toolbar>(R.id.toolbar).apply {
            setTitle(title)
        }
    }
}
