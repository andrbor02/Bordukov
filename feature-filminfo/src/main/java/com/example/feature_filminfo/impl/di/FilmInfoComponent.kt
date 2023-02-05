package com.example.feature_filminfo.impl.di

import com.example.core_utils.annotations.PerFeature
import com.example.feature_filminfo.api.FilmInfoDependencies
import com.example.feature_filminfo.api.FilmInfoApi
import com.example.feature_filminfo.impl.presentation.ui.FilmInfoFragment
import dagger.Component

@PerFeature
@Component (
    dependencies = [FilmInfoDependencies::class],
    modules = [FilmInfoModule::class]
)
interface FilmInfoComponent: FilmInfoApi {
    fun inject(fragment: FilmInfoFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: FilmInfoDependencies): FilmInfoComponent
    }

    companion object {
        fun initAndGet(dependencies: FilmInfoDependencies): FilmInfoComponent {
            return DaggerFilmInfoComponent.factory().create(dependencies)
        }
    }
}