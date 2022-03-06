package com.grjt.supermarvel.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.grjt.supermarvel.core.Resource
import com.grjt.supermarvel.repository.SuperRepository
import kotlinx.coroutines.Dispatchers

class SuperheroViewModel(private val repo: SuperRepository): ViewModel() {

    fun fetchSuperhero() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getSuperhero()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun fetchItemSuperhero(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getItemSuperhero(id)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun fetchComicSuperhero(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getComicSuperhero(id)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun fetchEventSuperhero(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getEventSuperhero(id)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun fetchSeriesSuperhero(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getSeriesSuperhero(id)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun fetchStoriesSuperhero(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getStoriesSuperhero(id)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}

class SuperViewModelFactory(private val repo: SuperRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SuperRepository::class.java).newInstance(repo)
    }
}