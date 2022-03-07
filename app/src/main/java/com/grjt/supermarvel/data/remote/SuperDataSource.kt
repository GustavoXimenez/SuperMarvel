package com.grjt.supermarvel.data.remote

import com.grjt.supermarvel.application.AppConstants
import com.grjt.supermarvel.data.model.DataSuperhero

class SuperDataSource(private val webService: WebService) {

    suspend fun getSuperhero(): DataSuperhero =
        webService.getSuperhero(1, AppConstants.API_KEY, AppConstants.HASH)

    suspend fun getItemSuperhero(id: Int): DataSuperhero =
        webService.getItemSuperhero(id, 1, AppConstants.API_KEY, AppConstants.HASH)

    suspend fun getComicSuperhero(id: Int): DataSuperhero =
        webService.getComicSuperhero(id, 1, AppConstants.API_KEY, AppConstants.HASH)

    suspend fun getEventSuperhero(id: Int): DataSuperhero =
        webService.getEventSuperhero(id, 1, AppConstants.API_KEY, AppConstants.HASH)

    suspend fun getSeriesSuperhero(id: Int): DataSuperhero =
        webService.getSeriesSuperhero(id, 1, AppConstants.API_KEY, AppConstants.HASH)

    suspend fun getStoriesSuperhero(id: Int): DataSuperhero =
        webService.getStoriesSuperhero(id, 1, AppConstants.API_KEY, AppConstants.HASH)

}