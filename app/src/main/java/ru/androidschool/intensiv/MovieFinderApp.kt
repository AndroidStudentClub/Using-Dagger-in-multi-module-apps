package ru.androidschool.intensiv

import android.app.Application
import ru.androidschool.core_network.di.DaggerNetworkComponent
import ru.androidschool.intensiv.di.AppComponent
import ru.androidschool.intensiv.di.DaggerAppComponent
import timber.log.Timber

class MovieFinderApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        initDebugTools()
        buildNetworkComponent()
    }

    private fun buildNetworkComponent(){
        val networkComponent = DaggerNetworkComponent.create()
        appComponent = DaggerAppComponent.factory().create(networkComponent, applicationContext)
    }

    private fun initDebugTools() {
        if (BuildConfig.DEBUG) {
            initTimber()
        }
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        var instance: MovieFinderApp? = null
            private set
    }
}
