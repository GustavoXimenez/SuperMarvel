package com.grjt.supermarvel.domain

import com.grjt.supermarvel.data.model.Superhero
import com.grjt.supermarvel.data.repository.SuperRepository

class GetSeriesSuperheroUseCase(private val repository: SuperRepository) {

    suspend operator fun invoke(id: Int): List<Superhero> = repository.getSeriesSuperhero(id).data.results

}