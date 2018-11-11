package au.com.wipro.newsfeed.feedlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.wipro.newsfeed.domain.Feed
import au.com.wipro.newsfeed.repository.FeedRepository
import au.com.wipro.newsfeed.repository.FeedRepositoryImpl


class FeedViewModel : ViewModel() {
    val feedLiveData: MutableLiveData<Feed> = MutableLiveData()

    //TODO: INJECT
    private val feedRepo: FeedRepository

    init {
        feedRepo = FeedRepositoryImpl()
    }

    fun refresh() {
        feedLiveData.postValue(feedRepo.get())
    }
}
