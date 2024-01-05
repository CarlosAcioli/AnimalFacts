package com.acioli.animalsfacts.cats_facts.data.api

import com.acioli.animalsfacts.cats_facts.domain.model.CatFacts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {

    @GET("/")
    suspend fun getRandomCatsFacts(@Query("count") count: Int): Response<CatFacts>

}