package com.example.feature_filmlist.impl.di

import com.example.core_utils.annotations.PerFeature
import com.example.feature_filmlist.api.FilmListApi
import com.example.feature_filmlist.api.FilmListDependencies
import com.example.feature_filmlist.impl.presentation.ui.FilmListFragment
import dagger.Component

@PerFeature
@Component (
    dependencies = [FilmListDependencies::class],
    modules = [FilmListModule::class]
)
interface FilmListComponent: FilmListApi {
    fun inject(fragment: FilmListFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: FilmListDependencies): FilmListComponent
    }

    companion object {
        fun initAndGet(dependencies: FilmListDependencies): FilmListComponent {
            return DaggerFilmListComponent.factory().create(dependencies)
        }
    }
}