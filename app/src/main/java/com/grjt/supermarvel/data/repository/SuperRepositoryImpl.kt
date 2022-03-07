package com.grjt.supermarvel.data.repository

import com.grjt.supermarvel.data.model.DataSuperhero
import com.grjt.supermarvel.data.remote.SuperDataSource

class SuperRepositoryImpl(private val dataSource: SuperDataSource): SuperRepository {

    override suspend fun getSuperhero(): DataSuperhero = dataSource.getSuperhero()

    override suspend fun getItemSuperhero(id: Int): DataSuperhero = dataSource.getItemSuperhero(id)

    override suspend fun getComicSuperhero(id: Int): DataSuperhero = dataSource.getComicSuperhero(id)

    override suspend fun getEventSuperhero(id: Int): DataSuperhero = dataSource.getEventSuperhero(id)

    override suspend fun getSeriesSuperhero(id: Int): DataSuperhero = dataSource.getSeriesSuperhero(id)

    override suspend fun getStoriesSuperhero(id: Int): DataSuperhero = dataSource.getStoriesSuperhero(id)

}