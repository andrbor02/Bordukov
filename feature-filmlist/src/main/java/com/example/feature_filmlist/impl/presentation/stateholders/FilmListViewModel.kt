package com.example.feature_filmlist.impl.presentation.stateholders

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_model.Film
import com.example.core_utils.datawrappers.Result
import com.example.feature_filmlist.impl.domain.usecase.GetFilmListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FilmListViewModel @Inject constructor(
    private val getFilmListUseCase: GetFilmListUseCase,
) : ViewModel() {

    private var _filmListLD = MutableLiveData<Result<List<Film>>>()
    val filmListLD: LiveData<Result<List<Film>>> = _filmListLD

    init {
        initWithFilters()
    }

    private fun initWithFilters() {
        viewModelScope.launch {
            getFilmListUseCase().collect { _filmListLD.value = it }
        }
    }
}