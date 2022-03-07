package com.grjt.supermarvel.domain

import com.grjt.supermarvel.data.model.Superhero
import com.grjt.supermarvel.data.repository.SuperRepository

class GetSuperheroUseCase(private val repository: SuperRepository) {

    suspend operator fun invoke(): List<Superhero> = repository.getSuperhero().data.results

}