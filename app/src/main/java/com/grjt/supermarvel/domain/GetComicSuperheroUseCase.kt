package com.grjt.supermarvel.domain

import com.grjt.supermarvel.data.model.Superhero
import com.grjt.supermarvel.data.repository.SuperRepositoryImpl
import javax.inject.Inject

class GetComicSuperheroUseCase @Inject constructor(private val repository: SuperRepositoryImpl) {

    suspend operator fun invoke(id: Int): List<Superhero> = repository.getComicSuperhero(id).data.results

}