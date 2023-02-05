package com.example.feature_filminfo.impl.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_filminfo.impl.domain.usecase.GetFilmByIdUseCase
import javax.inject.Inject

class FilmInfoViewModelFactory @Inject constructor(
    private val getFilmByIdUseCase: GetFilmByIdUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == FilmInfoViewModel::class)
        return FilmInfoViewModel(
            getFilmByIdUseCase = getFilmByIdUseCase,
        ) as T
    }

}