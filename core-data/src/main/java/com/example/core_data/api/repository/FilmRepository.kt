package com.example.core_data.api.repository

import com.example.core_model.Film
import com.example.core_model.filmbyid.FilmInfo
import com.example.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.Flow

interface FilmRepository {

    suspend fun getAll(): Flow<Result<List<Film>>>

    suspend fun getById(id: Long): Flow<Result<FilmInfo>>
}