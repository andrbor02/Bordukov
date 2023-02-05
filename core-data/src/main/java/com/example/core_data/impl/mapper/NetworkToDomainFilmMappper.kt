package com.example.core_data.impl.mapper

import com.example.core_model.Film
import com.example.core_network.impl.model.toplist.NetworkFilm

object NetworkToDomainFilmMappper : Mappers.NetworkToDomainFilmMapper {
    override fun invoke(networkFilm: NetworkFilm): Film {
        return Film(
            id = networkFilm.id,
            name = (networkFilm.nameRu ?: networkFilm.nameEn)!!,
            poster = networkFilm.posterUrlPreview,
            year = (networkFilm.year ?: "").toInt(),
        )
    }
}