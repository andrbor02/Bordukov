package com.example.core_data.impl.di

import com.example.core_data.api.DataApi
import com.example.core_data.api.DataDependencies
import dagger.Component
import javax.inject.Singleton
import com.example.core_network.impl.di.NetworkModule


@Component(
    dependencies = [DataDependencies::class],
    modules = [
        CoreDataModule::class,

        CoreNetworkProviderModule::class,
        NetworkModule::class,
    ]
)
@Singleton
interface CoreDataComponent: DataApi {
    @Component.Factory
    interface Factory {
        fun create(dependencies: DataDependencies): CoreDataComponent
    }

    companion object {

        private var component: CoreDataComponent? = null

        fun initAndGet(dependencies: DataDependencies): CoreDataComponent {
            if (component == null) {
                synchronized(CoreDataComponent::class.java) {
                    if (component == null) {
                        component = DaggerCoreDataComponent.factory().create(dependencies)
                    }
                }
            }
            return component!!
        }
    }
}