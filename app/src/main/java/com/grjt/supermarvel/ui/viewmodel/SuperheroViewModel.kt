package com.grjt.supermarvel.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.grjt.supermarvel.core.Resource
import com.grjt.supermarvel.domain.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class SuperheroViewModel @Inject constructor (
    private val getSuperheroUseCase: GetSuperheroUseCase,
    private val getItemSuperheroUseCase: GetItemSuperheroUseCase,
    private val getComicSuperheroUseCase: GetComicSuperheroUseCase,
    private val getEventSuperheroUseCase: GetEventSuperheroUseCase,
    private val getSeriesSuperheroUseCase: GetSeriesSuperheroUseCase,
    private val getStorySuperheroUseCase: GetStorySuperheroUseCase,
): ViewModel() {

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

