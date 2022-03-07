package com.grjt.supermarvel.domain

import com.grjt.supermarvel.data.model.Superhero
import com.grjt.supermarvel.data.repository.SuperRepository

class GetEventSuperheroUseCase(private val repository: SuperRepository) {

    suspend operator fun invoke(id: Int): List<Superhero> = repository.getEventSuperhero(id).data.results

}