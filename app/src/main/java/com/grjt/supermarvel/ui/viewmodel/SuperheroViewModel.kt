package com.grjt.supermarvel.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.grjt.supermarvel.core.Resource
import com.grjt.supermarvel.data.repository.SuperRepository
import com.grjt.supermarvel.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperheroViewModel(private val repo: SuperRepository): ViewModel() {

    private val getSuperheroUseCase = GetSuperheroUseCase(repo)
    private val getItemSuperheroUseCase = GetItemSuperheroUseCase(repo)
    private val getComicSuperheroUseCase = GetComicSuperheroUseCase(repo)
    private val getEventSuperheroUseCase = GetEventSuperheroUseCase(repo)
    private val getSeriesSuperheroUseCase = GetSeriesSuperheroUseCase(repo)
    private val getStorySuperheroUseCase = GetStorySuperheroUseCase(repo)


    fun onCreate() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(getSuperheroUseCase()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun fetchItemSuperhero(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(getItemSuperheroUseCase(id)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun fetchComicSuperhero(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(getComicSuperheroUseCase(id)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun fetchEventSuperhero(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(getEventSuperheroUseCase(id)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun fetchSeriesSuperhero(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(getSeriesSuperheroUseCase(id)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun fetchStoriesSuperhero(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(getStorySuperheroUseCase(id)))
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