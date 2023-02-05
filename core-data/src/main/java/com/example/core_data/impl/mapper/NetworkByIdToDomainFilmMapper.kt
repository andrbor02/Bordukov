package com.example.core_data.impl.mapper

import com.example.core_model.filmbyid.FilmInfo
import com.example.core_network.impl.model.filmbyid.NetworkFilmById

object NetworkByIdToDomainFilmMapper : Mappers.NetworkByIdToDomainFilmMapper {
    override fun invoke(networkFilmById: NetworkFilmById): FilmInfo {
        return FilmInfo(
            id = networkFilmById.id,
            poster = networkFilmById.posterUrl,
            description = networkFilmById.description ?: "",
            genres = networkFilmById.genres,
            countries = networkFilmById.countries,
        )
    }
}