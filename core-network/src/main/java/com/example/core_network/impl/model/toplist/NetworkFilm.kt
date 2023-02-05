package com.example.core_network.impl.model.toplist

import com.google.gson.annotations.SerializedName

data class NetworkFilm(

    @SerializedName("filmId")
    val id: Int,
    @SerializedName("nameRu")
    val nameRu: String?,
    @SerializedName("nameEn")
    val nameEn: String?,
    @SerializedName("year")
    val year: String?,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String,
)