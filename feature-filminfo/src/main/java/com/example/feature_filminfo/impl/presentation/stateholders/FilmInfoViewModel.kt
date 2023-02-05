package com.example.feature_filminfo.impl.presentation.stateholders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_model.filmbyid.FilmInfo
import com.example.core_utils.datawrappers.Result
import com.example.feature_filminfo.impl.domain.usecase.GetFilmByIdUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class FilmInfoViewModel(
    private val getFilmByIdUseCase: GetFilmByIdUseCase,
) : ViewModel() {

    private var _currentFilmLD = MutableLiveData<Result<FilmInfo>>()
    val currentFilmLD: LiveData<Result<FilmInfo>> = _currentFilmLD

    fun getById(id: Long) {
        viewModelScope.launch {
            val result = getFilmByIdUseCase(id).first()
            _currentFilmLD.value = result
        }
    }
}