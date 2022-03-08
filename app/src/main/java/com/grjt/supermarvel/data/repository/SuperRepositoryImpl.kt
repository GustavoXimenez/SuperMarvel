package com.grjt.supermarvel.data.repository

import com.grjt.supermarvel.data.database.dao.SuperheroDao
import com.grjt.supermarvel.data.database.entities.SuperheroEntity
import com.grjt.supermarvel.data.model.DataSuperhero
import com.grjt.supermarvel.data.model.SuperheroModel
import com.grjt.supermarvel.data.remote.SuperDataSource
import com.grjt.supermarvel.domain.model.Superhero
import com.grjt.supermarvel.domain.model.toDomain
import javax.inject.Inject

class SuperRepositoryImpl @Inject constructor(
    private val dataSource: SuperDataSource,
    private val superheroDao: SuperheroDao
) {

    suspend fun getSuperheroFromApi(): List<Superhero> {
        val response = dataSource.getSuperhero()
        return response.data.results.map {
            it.toDomain()
        }
    }

    suspend fun getSuperheroFromDatabase(): List<Superhero> {
        val response = superheroDao.getAllSuperHero()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun getItemSuperhero(id: Int): DataSuperhero = dataSource.getItemSuperhero(id)

    suspend fun getComicSuperhero(id: Int): DataSuperhero = dataSource.getComicSuperhero(id)

    suspend fun getEventSuperhero(id: Int): DataSuperhero = dataSource.getEventSuperhero(id)

    suspend fun getSeriesSuperhero(id: Int): DataSuperhero = dataSource.getSeriesSuperhero(id)

    suspend fun getStoriesSuperhero(id: Int): DataSuperhero = dataSource.getStoriesSuperhero(id)

    suspend fun insertSuperhero(superheroes: List<SuperheroEntity>) = superheroDao.insertAll(superheroes)

    suspend fun clearSuperheroes() = superheroDao.clearSuperheroes()

}