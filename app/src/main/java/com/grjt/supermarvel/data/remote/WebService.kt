package com.grjt.supermarvel.data.remote

import com.grjt.supermarvel.data.model.DataSuperhero
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