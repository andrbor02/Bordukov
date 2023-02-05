package com.example.feature_filminfo.impl.di

import com.example.core_utils.annotations.PerFeature
import com.example.feature_filminfo.api.FilmInfoStarter
import com.example.feature_filminfo.impl.starter.FilmInfoStarterImpl
import dagger.Module
import dagger.Provides

@Module
class FilmInfoModule {

    @PerFeature
    @Provides
    fun provideStarter(): FilmInfoStarter {
        return FilmInfoStarterImpl()
    }
}
