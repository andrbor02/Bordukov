package com.example.core_network.impl.di

import com.example.core_network.impl.client.NetworkClient
import com.example.core_network.impl.client.NetworkClientImpl
import com.example.core_network.impl.datasource.FilmRemoteDataSource
import com.example.core_network.impl.datasource.retrofit.RetrofitClient
import com.example.core_network.impl.datasource.retrofit.FilmApi
import com.example.core_network.impl.datasource.retrofit.FilmRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideFilmRemoteDataSource(filmRemoteDataSourceImpl: FilmRemoteDataSourceImpl): FilmRemoteDataSource {
        return filmRemoteDataSourceImpl
    }

    @Singleton
    @Provides
    fun provideFilmApi(): FilmApi {
        return RetrofitClient.getFilmApi()
    }

    @Singleton
    @Provides
    fun provideNetworkClient(networkClientImpl: NetworkClientImpl): NetworkClient {
        return networkClientImpl
    }
}