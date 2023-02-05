package com.example.core_data.impl.repository

import com.example.core_data.api.repository.FilmRepository
import com.example.core_data.impl.mapper.NetworkByIdToDomainFilmMapper
import com.example.core_data.impl.mapper.NetworkToDomainFilmMappper
import com.example.core_model.Film
import com.example.core_model.filmbyid.FilmInfo
import com.example.core_network.impl.client.NetworkClient
import com.example.core_utils.datawrappers.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    networkClient: NetworkClient,
) : FilmRepository {

    private val networkDataSource = networkClient.getFilmRemoteDataSource()


    override suspend fun getAll(): Flow<Result<List<Film>>> {
        return networkDataSource.getFilmList().map { result ->

            result.map { networkList ->
                networkList.map { networkFilm ->
                    NetworkToDomainFilmMappper(networkFilm)
                }
            }
        }
    }

    override suspend fun getById(id: Long): Flow<Result<FilmInfo>> {
        return networkDataSource.getFilmById(id).map { result ->
            result.map { networkFilmById ->
                NetworkByIdToDomainFilmMapper(networkFilmById)
            }
        }
    }
}