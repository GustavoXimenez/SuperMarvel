package com.grjt.supermarvel.data.remote

import com.grjt.supermarvel.application.AppConstants
import com.grjt.supermarvel.data.model.DataSuperhero
import javax.inject.Inject

class SuperDataSource @Inject constructor(private val webService: WebService) {

    suspend fun getSuperhero(): DataSuperhero =
        webService.getSuperhero(AppConstants.TIME_STAMP, AppConstants.API_KEY, AppConstants.HASH)

    suspend fun getItemSuperhero(id: Int): DataSuperhero =
        webService.getItemSuperhero(id, AppConstants.TIME_STAMP, AppConstants.API_KEY, AppConstants.HASH)

    suspend fun getComicSuperhero(id: Int): DataSuperhero =
        webService.getComicSuperhero(id, AppConstants.TIME_STAMP, AppConstants.API_KEY, AppConstants.HASH)

    suspend fun getEventSuperhero(id: Int): DataSuperhero =
        webService.getEventSuperhero(id, AppConstants.TIME_STAMP, AppConstants.API_KEY, AppConstants.HASH)

    suspend fun getSeriesSuperhero(id: Int): DataSuperhero =
        webService.getSeriesSuperhero(id, AppConstants.TIME_STAMP, AppConstants.API_KEY, AppConstants.HASH)

    suspend fun getStoriesSuperhero(id: Int): DataSuperhero =
        webService.getStoriesSuperhero(id, AppConstants.TIME_STAMP, AppConstants.API_KEY, AppConstants.HASH)

}