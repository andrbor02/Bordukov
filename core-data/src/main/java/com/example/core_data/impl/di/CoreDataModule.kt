package com.example.core_data.impl.di

import android.content.Context
import com.example.core_data.api.repository.FilmRepository
import com.example.core_data.impl.repository.FilmRepositoryImpl
import com.example.core_network.api.NetworkApi
import com.example.core_network.api.NetworkDependencies
import com.example.core_network.impl.di.NetworkComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreDataModule {

    @Provides
    fun provideFilmRepository(filmRepositoryImpl: FilmRepositoryImpl): FilmRepository {
        return filmRepositoryImpl
    }
}


@Module
class CoreNetworkProviderModule {

    @Singleton
    @Provides
    fun provideCoreNetworkDependencies(context: Context): NetworkDependencies {
        return object : NetworkDependencies {
            override fun context(): Context {
                return context
            }
        }
    }

    @Provides
    fun provideCoreNetworkApi(dependencies: NetworkDependencies): NetworkApi {
        return NetworkComponent.initAndGet(dependencies)
    }
}