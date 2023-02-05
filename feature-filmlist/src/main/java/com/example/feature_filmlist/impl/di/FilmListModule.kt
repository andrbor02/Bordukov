package com.example.feature_filmlist.impl.di

import com.example.core_utils.annotations.PerFeature
import com.example.feature_filmlist.api.FilmListStarter
import com.example.feature_filmlist.impl.starter.FilmListStarterImpl
import dagger.Module
import dagger.Provides

@Module
class FilmListModule {

    @PerFeature
    @Provides
    fun provideStarter(): FilmListStarter {
        return FilmListStarterImpl()
    }
}
