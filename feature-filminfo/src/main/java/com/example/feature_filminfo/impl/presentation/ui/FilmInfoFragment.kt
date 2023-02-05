package com.example.feature_filminfo.impl.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.core_model.filmbyid.FilmInfo
import com.example.core_utils.datawrappers.Result
import com.example.feature_filminfo.R
import com.example.feature_filminfo.databinding.FragmentFilmInfoBinding
import com.example.feature_filminfo.impl.di.FilmInfoComponentHolder
import com.example.feature_filminfo.impl.presentation.stateholders.FilmInfoViewModel
import com.example.feature_filminfo.impl.presentation.stateholders.FilmInfoViewModelFactory
import javax.inject.Inject

class FilmInfoFragment : Fragment() {

    private val binding: FragmentFilmInfoBinding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentFilmInfoBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var filmInfoViewModelFactory: FilmInfoViewModelFactory

    private val viewModel: FilmInfoViewModel by viewModels {
        filmInfoViewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root

        FilmInfoComponentHolder.getComponent().inject(this)

        checkForArgs()
        setUpListeners()
        return view
    }

    private fun checkForArgs() {
        val argsKey = resources.getString(R.string.film_id)
        val argsValue = arguments?.getString(argsKey) ?: ""
        if (argsValue != "") {
            setExistingFilm(filmId = argsValue)
        }
    }

    private fun setUpListeners() {
        binding.closeBut.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setExistingFilm(filmId: String) {
        viewModel.getById(filmId.toLong())
        viewModel.currentFilmLD.observe(viewLifecycleOwner) { task ->
            when (task) {
                is Result.Success -> expandExistingFilm(task.value)
                is Result.Error -> Log.e("MMM", "Error")
                is Result.Loading -> Log.e("MMM", "Loading")
            }
        }
    }

    private fun expandExistingFilm(filmInfo: FilmInfo) {
        binding.description.text = filmInfo.description
        Glide.with(this)
            .load(filmInfo.poster)
            .placeholder(com.example.core_ui.R.drawable.poster_placeholder)
            .into(binding.poster)
        binding.country.text = filmInfo.countries.joinToString(" ")
        binding.genre.text = filmInfo.genres.joinToString(" ")
    }

    override fun onPause() {
        super.onPause()
        FilmInfoComponentHolder.reset()
    }
}