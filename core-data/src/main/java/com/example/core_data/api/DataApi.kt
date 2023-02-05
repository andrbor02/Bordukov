package com.example.core_data.api

import com.example.core_data.api.repository.FilmRepository
import com.example.core_model.BaseApi

interface DataApi: BaseApi {

    fun getFilmRepository(): FilmRepository
}