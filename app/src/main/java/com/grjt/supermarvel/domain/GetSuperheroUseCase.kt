package com.grjt.supermarvel.domain

import com.grjt.supermarvel.data.model.Superhero
import com.grjt.supermarvel.data.repository.SuperRepositoryImpl
import javax.inject.Inject

class GetSuperheroUseCase @Inject constructor(private val repository: SuperRepositoryImpl) {

    suspend operator fun invoke(): List<Superhero> = repository.getSuperhero().data.results

}