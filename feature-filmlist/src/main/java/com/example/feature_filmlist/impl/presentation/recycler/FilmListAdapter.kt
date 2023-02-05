package com.example.feature_filmlist.impl.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core_model.Film
import com.example.feature_filmlist.databinding.FilmItemBinding

class FilmListAdapter(
    filmListDiffUtil: FilmListDiffUtil,
    private val filmClickListener: FilmClickListener
) :
    ListAdapter<Film, FilmListViewHolder>(filmListDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemTaskBinding = FilmItemBinding.inflate(layoutInflater, parent, false)

        return FilmListViewHolder(itemTaskBinding)
    }

    override fun onBindViewHolder(holder: FilmListViewHolder, position: Int) {
        holder.bindTask(getItem(position), filmClickListener)
    }
}