package au.com.wipro.newsfeed.feedlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.wipro.newsfeed.domain.Feed
import au.com.wipro.newsfeed.repository.FeedRepository
import javax.inject.Inject


class FeedViewModel
@Inject constructor(private val feedRepo: FeedRepository) : ViewModel() {
    val feedLiveData: MutableLiveData<Feed> = MutableLiveData()

    fun refresh() {
        feedLiveData.postValue(feedRepo.get())
    }
}
