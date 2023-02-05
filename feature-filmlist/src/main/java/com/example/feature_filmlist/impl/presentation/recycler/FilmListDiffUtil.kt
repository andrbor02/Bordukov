package com.example.feature_filmlist.impl.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.core_model.Film

class FilmListDiffUtil : DiffUtil.ItemCallback<Film>() {
    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem == newItem
    }
}