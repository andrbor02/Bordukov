package com.example.core_model

import java.io.Serializable

data class Film(
    val id: Int,
    val name: String,
    val poster: String,
    val year: Int
) : Serializable