package au.com.wipro.newsfeed.di

import au.com.wipro.newsfeed.feed.FeedActivity
import au.com.wipro.newsfeed.feedlist.FeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun feedActivity(): FeedActivity

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun feedFragment(): FeedFragment
}