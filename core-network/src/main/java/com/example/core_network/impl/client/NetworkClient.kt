package com.example.core_network.impl.client

import com.example.core_network.impl.datasource.FilmRemoteDataSource

interface NetworkClient {

    fun getFilmRemoteDataSource(): FilmRemoteDataSource
}