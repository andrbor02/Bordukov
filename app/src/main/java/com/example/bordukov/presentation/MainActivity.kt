package com.example.bordukov.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.bordukov.R
import com.example.bordukov.app.App
import com.example.bordukov.routing.Navigator
import com.example.feature_filmlist.api.FilmListApi
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var filmListApi: FilmListApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.injectToMainActivity(this)
    }

    override fun onResume() {
        super.onResume()
        navigator.bind(findNavController(R.id.main_nav_host))
    }

    override fun onPause() {
        super.onPause()
        navigator.unbind()
    }
}