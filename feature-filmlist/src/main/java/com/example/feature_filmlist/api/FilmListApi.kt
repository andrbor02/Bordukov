package com.example.feature_filmlist.api

import com.example.core_model.BaseApi

interface FilmListApi: BaseApi {

    fun starter(): FilmListStarter
}