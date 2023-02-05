package com.example.feature_filmlist.impl.presentation.recycler

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.core_model.Film
import com.example.feature_filmlist.databinding.FilmItemBinding

class FilmListViewHolder(
    private val binding: FilmItemBinding
) : RecyclerView.ViewHolder(binding.root) {


    @SuppressLint("ResourceAsColor")
    fun bindTask(film: Film, listener: FilmClickListener) {
        binding.apply {
            name.text = film.name
            year.text = film.year.toString()
            filmItem.setOnClickListener { listener.onItemClick(film) }
        }
    }
}