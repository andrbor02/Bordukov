package com.example.feature_filmlist.impl.domain.usecase

import com.example.core_data.api.repository.FilmRepository
import com.example.core_model.Film
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.example.core_utils.datawrappers.*

class GetFilmListUseCase @Inject constructor(
    private val filmRepository: FilmRepository
) {
    suspend operator fun invoke(): Flow<Result<List<Film>>> {
        return filmRepository.getAll()
    }
}