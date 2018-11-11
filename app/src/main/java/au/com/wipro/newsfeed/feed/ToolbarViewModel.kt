package au.com.wipro.newsfeed.feed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject


class ToolbarViewModel
@Inject constructor() : ViewModel() {

    val toolbarLiveData: MutableLiveData<String> = MutableLiveData()

    fun setToolbarTitle(title: String?) {
        toolbarLiveData.postValue(title)
    }
}