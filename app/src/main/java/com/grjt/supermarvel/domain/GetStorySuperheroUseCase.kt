package com.grjt.supermarvel.domain

import com.grjt.supermarvel.data.model.SuperheroModel
import com.grjt.supermarvel.data.repository.SuperRepositoryImpl
import javax.inject.Inject

class GetStorySuperheroUseCase @Inject constructor(private val repository: SuperRepositoryImpl) {

    suspend operator fun invoke(id: Int): List<SuperheroModel> = repository.getStoriesSuperhero(id).data.results

}