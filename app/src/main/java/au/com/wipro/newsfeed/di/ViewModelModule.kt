package au.com.wipro.newsfeed.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import au.com.wipro.newsfeed.feed.ToolbarViewModel
import au.com.wipro.newsfeed.feedlist.FeedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ToolbarViewModel::class)
    internal abstract fun toolbarViewModel(viewModel: ToolbarViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    internal abstract fun feedViewModel(viewModel: FeedViewModel): ViewModel

}