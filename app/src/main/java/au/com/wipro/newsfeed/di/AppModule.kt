package au.com.wipro.newsfeed.di

import au.com.wipro.newsfeed.helper.ImageLoader
import au.com.wipro.newsfeed.helper.ImageLoaderImpl
import au.com.wipro.newsfeed.networking.DropBoxData
import au.com.wipro.newsfeed.networking.DropBoxDataImpl
import au.com.wipro.newsfeed.repository.FeedRepository
import au.com.wipro.newsfeed.repository.FeedRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun dropBoxData(): DropBoxData = DropBoxDataImpl

    @Provides
    @Singleton
    fun imageLoader(): ImageLoader = ImageLoaderImpl

    @Provides
    @Singleton
    fun feedRepo(): FeedRepository = FeedRepositoryImpl()

}