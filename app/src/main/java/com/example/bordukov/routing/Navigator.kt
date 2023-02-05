package com.example.bordukov.routing

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import com.example.feature_filmlist.impl.presentation.navigation.FilmListNavigation
import com.example.feature_filminfo.api.FilmInfoApi
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor(
    private val featureFilmInfo: Provider<FilmInfoApi>,
): FilmListNavigation {

    private var navContr: NavController? = null

    @Inject
    lateinit var uriCreator: UriCreator

    override fun showFilmInfo(filmId: Long) {
        featureFilmInfo.get().starter().start()
        val uri = uriCreator.createWithArgs(
            uriRes = com.example.feature_filminfo.R.string.uri_film_info_expect_argument,
            argsPlaceHolderRes = com.example.feature_filminfo.R.string.film_id,
            args = filmId.toString()
        )
        val request = NavDeepLinkRequest.Builder
            .fromUri(uri)
            .build()
        Log.e("MMM", "Navigator: film $filmId and uri $uri")
        navContr?.navigate(request)
    }


    fun bind(navController: NavController) {
        navContr = navController
    }

    fun unbind() {
        navContr = null
    }
}