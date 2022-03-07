package com.grjt.supermarvel.data.repository

import com.grjt.supermarvel.data.model.DataSuperhero

interface SuperRepository {

    suspend fun getSuperhero(): DataSuperhero

    suspend fun getItemSuperhero(id: Int): DataSuperhero

    suspend fun getComicSuperhero(id: Int): DataSuperhero

    suspend fun getEventSuperhero(id: Int): DataSuperhero

    suspend fun getSeriesSuperhero(id: Int): DataSuperhero

    suspend fun getStoriesSuperhero(id: Int): DataSuperhero

}