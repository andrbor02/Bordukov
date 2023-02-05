package com.example.feature_filminfo.impl.domain.usecase

import com.example.core_data.api.repository.FilmRepository
import com.example.core_model.filmbyid.FilmInfo
import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFilmByIdUseCase @Inject constructor(
    private val repository: FilmRepository
) {
    suspend operator fun invoke(id: Long): Flow<Result<FilmInfo>> {
        return repository.getById(id)
    }
}