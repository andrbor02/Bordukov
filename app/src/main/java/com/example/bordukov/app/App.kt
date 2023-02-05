package com.example.bordukov.app

import android.app.Application
import com.example.bordukov.di.AppComponent
import com.example.bordukov.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this)
    }

}