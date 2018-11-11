package au.com.wipro.newsfeed.feedlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.wipro.newsfeed.domain.Feed
import au.com.wipro.newsfeed.repository.FeedRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class FeedViewModel
@Inject constructor(private val feedRepo: FeedRepository) : ViewModel(), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    val feedLiveData: MutableLiveData<Feed> = MutableLiveData()

    fun refresh() {
        this.launch(context = coroutineContext) {
            feedLiveData.postValue(feedRepo.get())
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
