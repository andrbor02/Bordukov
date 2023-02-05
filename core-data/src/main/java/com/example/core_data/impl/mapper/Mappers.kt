package com.example.core_data.impl.mapper

import com.example.core_model.Film
import com.example.core_model.filmbyid.FilmInfo
import com.example.core_network.impl.model.filmbyid.NetworkFilmById
import com.example.core_network.impl.model.toplist.NetworkFilm


interface Mappers {

    interface NetworkToDomainFilmMapper {
        operator fun invoke(networkFilm: NetworkFilm): Film
    }

    interface NetworkByIdToDomainFilmMapper {
        operator fun invoke(networkFilmById: NetworkFilmById): FilmInfo
    }
}