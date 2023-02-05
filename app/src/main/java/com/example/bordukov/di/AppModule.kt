package com.example.bordukov.di

import android.content.Context
import com.example.core_data.api.DataApi
import com.example.core_data.api.DataDependencies
import com.example.core_data.api.repository.FilmRepository
import com.example.core_data.impl.di.CoreDataComponent
import com.example.feature_filminfo.api.FilmInfoDependencies
import com.example.feature_filmlist.api.FilmListDependencies
import com.example.feature_filmlist.api.FilmListApi
import com.example.feature_filmlist.impl.di.FilmListComponentHolder
import com.example.feature_filmlist.impl.presentation.navigation.FilmListNavigation
import com.example.feature_filminfo.api.FilmInfoApi
import com.example.feature_filminfo.impl.di.FilmInfoComponentHolder
import com.example.bordukov.routing.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

}

@Module
class FeatureFilmListProviderModule {

    @Provides
    fun provideFilmListDependencies(
        dataApi: DataApi,
        navigation: Navigator,
    ): FilmListDependencies {
        return object : FilmListDependencies {
            override fun filmRepository(): FilmRepository {
                return dataApi.getFilmRepository()
            }

            override fun navigation(): FilmListNavigation {
                return navigation
            }
        }
    }

    @Provides
    fun provideFilmListApi(dependencies: FilmListDependencies): FilmListApi {
        FilmListComponentHolder.init(dependencies)
        return FilmListComponentHolder.get()
    }

}

@Module
class FeatureFilmInfoProviderModule {
    @Singleton
    @Provides
    fun provideFilmInfoDependencies(
        coreDataApi: DataApi
    ): FilmInfoDependencies {
        return object : FilmInfoDependencies {
            override fun repository(): FilmRepository {
                return coreDataApi.getFilmRepository()
            }
        }
    }

    @Provides
    fun provideFilmInfoApi(dependencies: FilmInfoDependencies): FilmInfoApi {
        FilmInfoComponentHolder.init(dependencies)
        return FilmInfoComponentHolder.get()
    }

}

@Module
class CoreDataProviderModule {

    @Singleton
    @Provides
    fun provideCoreDataDependencies(context: Context): DataDependencies {
        return object : DataDependencies {
            override fun context(): Context {
                return context
            }
        }
    }

    @Provides
    fun provideCoreDataApi(dependencies: DataDependencies): DataApi {
        return CoreDataComponent.initAndGet(dependencies)
    }

}