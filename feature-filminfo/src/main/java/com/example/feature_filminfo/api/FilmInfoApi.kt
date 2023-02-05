package com.example.feature_filminfo.api

import com.example.core_model.BaseApi

interface FilmInfoApi: BaseApi {

    fun starter(): FilmInfoStarter
}