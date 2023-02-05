package com.example.bordukov.di

import android.content.Context
import com.example.bordukov.presentation.MainActivity
import com.example.core_data.impl.di.CoreDataModule
import com.example.core_data.impl.di.CoreNetworkProviderModule
import com.example.core_network.impl.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Component(
    modules = [
        AppModule::class,
        FeatureFilmListProviderModule::class,
        FeatureFilmInfoProviderModule::class,
        CoreDataProviderModule::class,

        CoreDataModule::class,
        NetworkModule::class,
        CoreNetworkProviderModule::class,
    ]
)
@Singleton
interface AppComponent {

    fun injectToMainActivity(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }
}