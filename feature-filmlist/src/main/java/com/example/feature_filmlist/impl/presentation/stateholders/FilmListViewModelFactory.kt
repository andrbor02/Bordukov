package com.example.feature_filmlist.impl.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_filmlist.impl.domain.usecase.GetFilmListUseCase
import javax.inject.Inject

class FilmListViewModelFactory @Inject constructor(
    private val getFilmListUseCase: GetFilmListUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == FilmListViewModel::class)
        return FilmListViewModel(
            getFilmListUseCase = getFilmListUseCase,
        ) as T
    }
}