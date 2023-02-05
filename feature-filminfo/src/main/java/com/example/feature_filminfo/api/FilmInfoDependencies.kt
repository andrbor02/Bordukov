package com.example.feature_filminfo.api

import com.example.core_data.api.repository.FilmRepository
import com.example.core_model.BaseDependencies

interface FilmInfoDependencies: BaseDependencies {
    fun repository(): FilmRepository
}