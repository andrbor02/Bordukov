package com.example.core_network.impl.client

import com.example.core_network.impl.datasource.FilmRemoteDataSource
import javax.inject.Inject

class NetworkClientImpl @Inject constructor(
    private val filmRemoteDataSource: FilmRemoteDataSource
) : NetworkClient {

    override fun getFilmRemoteDataSource(): FilmRemoteDataSource {
        return filmRemoteDataSource
    }
}