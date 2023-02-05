package com.example.core_model.filmbyid

data class FilmInfo(
    val id: Int,
    val poster: String,
    val description: String,
    val genres: List<Genre>,
    val countries: List<Country>,
    )
