package com.example.core_network.impl.datasource.retrofit

import android.util.Log
import com.example.core_network.impl.datasource.FilmRemoteDataSource
import com.example.core_network.impl.model.filmbyid.NetworkFilmById
import com.example.core_network.impl.model.toplist.NetworkFilm
import com.example.core_network.impl.model.toplist.TopFilmsResponse
import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import javax.inject.Inject

class FilmRemoteDataSourceImpl @Inject constructor(
    private val filmApi: FilmApi,
) : FilmRemoteDataSource {

    val filmListFlow = MutableStateFlow<Result<List<NetworkFilm>>>(Result.Loading())

    override suspend fun getFilmList(): Flow<Result<List<NetworkFilm>>> {
        filmApi.getFilmList().enqueue(object : Callback<TopFilmsResponse> {
            override fun onResponse(
                call: Call<TopFilmsResponse>,
                response: Response<TopFilmsResponse>
            ) {
                filmListFlow.value = Result.Success(
                    response.body()?.films ?: emptyList()
                )
            }

            override fun onFailure(call: Call<TopFilmsResponse>, t: Throwable) {
                filmListFlow.value = Result.Error(t)
            }
        })
        return filmListFlow
    }

    override suspend fun getFilmById(id: Long): Flow<Result<NetworkFilmById>> {
        return flowOf(
            Result.Success(
                filmApi.getFilmById(id.toString()).await()
            )
        )
    }
}