package com.example.feature_filmlist.impl.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core_model.Film
import com.example.core_utils.datawrappers.Result
import com.example.feature_filmlist.databinding.FragmentFilmListBinding
import com.example.feature_filmlist.impl.di.FilmListComponentHolder
import com.example.feature_filmlist.impl.presentation.navigation.FilmListNavigation
import com.example.feature_filmlist.impl.presentation.stateholders.FilmListViewModel
import com.example.feature_filmlist.impl.presentation.stateholders.FilmListViewModelFactory
import com.example.feature_filmlist.impl.presentation.recycler.FilmClickListener
import com.example.feature_filmlist.impl.presentation.recycler.FilmListAdapter
import com.example.feature_filmlist.impl.presentation.recycler.FilmListDiffUtil
import javax.inject.Inject


class FilmListFragment : Fragment(), FilmClickListener {

    private val binding: FragmentFilmListBinding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentFilmListBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var filmListViewModelFactory: FilmListViewModelFactory

    @Inject
    lateinit var navigation: FilmListNavigation

    private val viewModel: FilmListViewModel by viewModels {
        filmListViewModelFactory
    }

    private var adapter: FilmListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root

        FilmListComponentHolder.getComponent().inject(this)

        setUpRecycler()
        setUpObservers()

        return view
    }

    private fun setUpRecycler() {

        val tasksRecyclerView = binding.todoRecyclerView
        tasksRecyclerView.layoutManager = LinearLayoutManager(activity)

        val filmListDiffUtil = FilmListDiffUtil()
        adapter = FilmListAdapter(
            filmListDiffUtil,
            this
        )
        tasksRecyclerView.adapter = adapter
    }

    private fun setUpObservers() {
        viewModel.filmListLD.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Result.Success -> {
                    adapter?.submitList(response.value)
                    dataIsLoaded()
                }
                is Result.Error -> {
                    Log.e("MMM", "ERERERER")
                    showResponseError()}
                is Result.Loading -> showLoading()

            }
        }
    }

    private fun showLoading() {
        binding.todoRecyclerView.isVisible = false
        binding.progress.isVisible = true
    }

    private fun dataIsLoaded() {
        binding.progress.isVisible = false
        binding.todoRecyclerView.isVisible = true
    }

    private fun showResponseError() {
        binding.progress.isVisible = false
        binding.responseError.isVisible = true
    }

    override fun onItemClick(film: Film) {
        Log.e("MMM", "onItemClick: ${film.name}")
        navigation.showFilmInfo(film.id.toLong())
    }

    override fun onDestroy() {
        super.onDestroy()
        FilmListComponentHolder.reset()
    }
}