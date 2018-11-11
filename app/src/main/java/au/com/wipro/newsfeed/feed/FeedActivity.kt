package au.com.wipro.newsfeed.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import au.com.wipro.newsfeed.R
import au.com.wipro.newsfeed.feedlist.FeedFragment
import org.jetbrains.anko.find


class FeedActivity : AppCompatActivity() {

    private var toolbarViewModel: ToolbarViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModels()
        showFeed()
    }

    /* ************ */
    /* INITIALISERS */
    /* ************ */
    private fun initViewModels() {
        toolbarViewModel = ViewModelProviders.of(this).get(ToolbarViewModel::class.java)
        toolbarViewModel?.toolbarLiveData?.observe(this, Observer {
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
