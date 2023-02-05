package com.example.core_network.impl.datasource

import com.example.core_network.impl.model.filmbyid.NetworkFilmById
import com.example.core_network.impl.model.toplist.NetworkFilm
import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow


interface FilmRemoteDataSource {

    suspend fun getFilmList(): Flow<Result<List<NetworkFilm>>>

    suspend fun getFilmById(id: Long): Flow<Result<NetworkFilmById>>
}