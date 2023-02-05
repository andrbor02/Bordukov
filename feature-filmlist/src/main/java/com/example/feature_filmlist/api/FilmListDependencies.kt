package com.example.feature_filmlist.api


import com.example.core_data.api.repository.FilmRepository
import com.example.core_model.BaseDependencies
import com.example.feature_filmlist.impl.presentation.navigation.FilmListNavigation

interface FilmListDependencies: BaseDependencies {

    fun filmRepository(): FilmRepository

    fun navigation(): FilmListNavigation
}