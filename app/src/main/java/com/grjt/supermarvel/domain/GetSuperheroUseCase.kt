package com.grjt.supermarvel.domain

import com.grjt.supermarvel.data.database.entities.toDomain
import com.grjt.supermarvel.data.repository.SuperRepositoryImpl
import com.grjt.supermarvel.domain.model.Superhero
import javax.inject.Inject

class GetSuperheroUseCase @Inject constructor(private val repository: SuperRepositoryImpl) {

    suspend operator fun invoke(): List<Superhero> {
        val superheroes = repository.getSuperheroFromApi()

        return if(superheroes.isNotEmpty()) {
            repository.clearSuperheroes()
            repository.insertSuperhero(superheroes.map { it.toDomain() })
            superheroes
        } else {
            repository.getSuperheroFromDatabase()
        }
    }

}