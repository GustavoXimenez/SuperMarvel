package com.grjt.supermarvel.domain

import com.grjt.supermarvel.data.model.Superhero
import com.grjt.supermarvel.data.repository.SuperRepository

class GetStorySuperheroUseCase(private val repository: SuperRepository) {

    suspend operator fun invoke(id: Int): List<Superhero> = repository.getStoriesSuperhero(id).data.results

}