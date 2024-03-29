package ru.androidschool.core_network.di

import dagger.Component
import javax.inject.Scope

@Scope
@Retention
annotation class NetworkScope

@Component(modules = [NetworkModule::class])
@NetworkScope
interface NetworkComponent {
    val movieApiInterface: MovieApiInterface
}

