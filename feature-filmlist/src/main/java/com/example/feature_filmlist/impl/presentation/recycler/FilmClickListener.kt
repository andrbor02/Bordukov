package com.example.feature_filmlist.impl.presentation.recycler

import com.example.core_model.Film


interface FilmClickListener {
    fun onItemClick(film: Film)
}