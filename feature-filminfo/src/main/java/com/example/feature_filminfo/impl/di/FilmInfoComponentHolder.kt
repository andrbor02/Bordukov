package com.example.feature_filminfo.impl.di

import com.example.core_model.ComponentHolder
import com.example.feature_filminfo.api.FilmInfoDependencies
import com.example.feature_filminfo.api.FilmInfoApi

object FilmInfoComponentHolder : ComponentHolder<FilmInfoApi, FilmInfoDependencies> {

    private var component: FilmInfoComponent? = null

    override fun init(dependencies: FilmInfoDependencies) {
        if (component == null) {
            synchronized(FilmInfoComponentHolder::class.java) {
                if (component == null) {
                    component = FilmInfoComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): FilmInfoApi = getComponent()

    internal fun getComponent(): FilmInfoComponent {
        checkNotNull(component) { "FilmInfoComponent is not initialized" }
        return component!!
    }

    override fun reset() {
        component = null
    }
}