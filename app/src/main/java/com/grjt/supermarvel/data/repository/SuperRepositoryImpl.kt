package com.grjt.supermarvel.data.repository

import com.grjt.supermarvel.data.model.DataSuperhero
import com.grjt.supermarvel.data.remote.SuperDataSource
import javax.inject.Inject

class SuperRepositoryImpl @Inject constructor(private val dataSource: SuperDataSource) {

    suspend fun getSuperhero(): DataSuperhero = dataSource.getSuperhero()

    suspend fun getItemSuperhero(id: Int): DataSuperhero = dataSource.getItemSuperhero(id)

    suspend fun getComicSuperhero(id: Int): DataSuperhero = dataSource.getComicSuperhero(id)

    suspend fun getEventSuperhero(id: Int): DataSuperhero = dataSource.getEventSuperhero(id)

    suspend fun getSeriesSuperhero(id: Int): DataSuperhero = dataSource.getSeriesSuperhero(id)

    suspend fun getStoriesSuperhero(id: Int): DataSuperhero = dataSource.getStoriesSuperhero(id)

}