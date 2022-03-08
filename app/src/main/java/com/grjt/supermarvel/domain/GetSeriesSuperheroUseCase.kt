package com.grjt.supermarvel.domain

import com.grjt.supermarvel.data.model.SuperheroModel
import com.grjt.supermarvel.data.repository.SuperRepositoryImpl
import javax.inject.Inject

class GetSeriesSuperheroUseCase @Inject constructor(private val repository: SuperRepositoryImpl) {

    suspend operator fun invoke(id: Int): List<SuperheroModel> = repository.getSeriesSuperhero(id).data.results

}