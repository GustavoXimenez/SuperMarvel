package com.grjt.supermarvel.data.remote

import com.google.gson.GsonBuilder
import com.grjt.supermarvel.application.AppConstants
import com.grjt.supermarvel.data.model.DataSuperhero
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {

    @GET("characters")
    suspend fun getSuperhero(
        @Query("ts") timeStamp: Int,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): DataSuperhero

    @GET("characters/{id}")
    suspend fun getItemSuperhero(
        @Path("id")id: Int,
        @Query("ts") timeStamp: Int,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
    ): DataSuperhero

    @GET("characters/{id}/comics")
    suspend fun getComicSuperhero(
        @Path("id")id: Int,
        @Query("ts") timeStamp: Int,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
    ): DataSuperhero

    @GET("characters/{id}/events")
    suspend fun getEventSuperhero(
        @Path("id")id: Int,
        @Query("ts") timeStamp: Int,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
    ): DataSuperhero

    @GET("characters/{id}/series")
    suspend fun getSeriesSuperhero(
        @Path("id")id: Int,
        @Query("ts") timeStamp: Int,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
    ): DataSuperhero

    @GET("characters/{id}/stories")
    suspend fun getStoriesSuperhero(
        @Path("id")id: Int,
        @Query("ts") timeStamp: Int,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
    ): DataSuperhero

}

object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }

}