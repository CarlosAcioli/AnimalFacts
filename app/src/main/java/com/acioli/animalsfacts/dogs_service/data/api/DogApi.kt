package com.acioli.animalsfacts.dogs_service.data.api

import com.acioli.animalsfacts.dogs_service.data.dto.DogFactsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface DogApi {

    @GET("/api/facts")
    suspend fun getRandomDogsFacts(@Query("number") number: Int): DogFactsDto

}