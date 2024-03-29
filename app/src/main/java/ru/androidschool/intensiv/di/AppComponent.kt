package ru.androidschool.intensiv.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.androidschool.core_network.di.NetworkComponent
import ru.androidschool.intensiv.MainActivity
import ru.androidschool.intensiv.ui.feed.FeedFragment
import javax.inject.Scope

@Scope
@Retention
annotation class ApplicationScope

@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class
    ],
    dependencies = [NetworkComponent::class]
)
@ApplicationScope
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            @BindsInstance applicationContext: Context
        ): AppComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(feedFragment: FeedFragment)
}