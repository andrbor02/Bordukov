package com.example.core_network.impl.datasource.retrofit

import com.example.core_network.impl.model.filmbyid.NetworkFilmById
import com.example.core_network.impl.model.toplist.TopFilmsResponse
import retrofit2.Call
import retrofit2.http.*

interface FilmApi {

    @GET("/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS&page=1")
    @Headers("x-api-key: 658e927b-287c-4804-a589-e3c43c0e45d6")
    fun getFilmList(): Call<TopFilmsResponse>

    @GET("/api/v2.2/films/{filmId}")
    @Headers("x-api-key: 658e927b-287c-4804-a589-e3c43c0e45d6")
    fun getFilmById(@Path("filmId") id: String): Call<NetworkFilmById>

}