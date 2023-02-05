package com.example.core_network.impl.model.filmbyid

import com.example.core_model.filmbyid.Country
import com.example.core_model.filmbyid.Genre
import com.google.gson.annotations.SerializedName

data class NetworkFilmById(
    @SerializedName("kinopoiskId")
    val id: Int,
    @SerializedName("description")
    val description: String?,
    @SerializedName("countries")
    val countries: List<Country>,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("posterUrl")
    val posterUrl: String,
)
