package au.com.wipro.newsfeed

import au.com.wipro.newsfeed.di.DaggerMainComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> {
        return DaggerMainComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        applicationInjector().inject(this)
    }
}