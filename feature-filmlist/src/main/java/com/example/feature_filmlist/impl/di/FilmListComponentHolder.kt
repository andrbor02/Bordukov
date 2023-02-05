package com.example.feature_filmlist.impl.di

import com.example.core_model.ComponentHolder
import com.example.feature_filmlist.api.FilmListDependencies
import com.example.feature_filmlist.api.FilmListApi


object FilmListComponentHolder : ComponentHolder<FilmListApi, FilmListDependencies> {

    private var component: FilmListComponent? = null

    override fun init(dependencies: FilmListDependencies) {
        if (component == null) {
            synchronized(FilmListComponentHolder::class.java) {
                if (component == null) {
                    component = FilmListComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): FilmListApi = getComponent()

    internal fun getComponent(): FilmListComponent {
        checkNotNull(component) { "FilmListComponent is not initialized" }
        return component!!
    }

    override fun reset() {
        component = null
    }
}