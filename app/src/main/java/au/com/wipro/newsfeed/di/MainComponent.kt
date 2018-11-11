package au.com.wipro.newsfeed.di

import au.com.wipro.newsfeed.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidBindingModule::class,
        AppModule::class,
        ViewModelModule::class
    ]
)
interface MainComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}