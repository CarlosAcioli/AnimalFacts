package com.acioli.animalsfacts.cats_facts.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.acioli.animalsfacts.cats_facts.constants.Results
import com.acioli.animalsfacts.cats_facts.data.api.CatApi
import com.acioli.animalsfacts.cats_facts.domain.model.CatFacts
import com.acioli.animalsfacts.cats_facts.domain.repository.CatFactsRepository
import retrofit2.Response
import java.net.ConnectException

class CatFactsRepositoryImpl(
    private val catApi: CatApi
) : CatFactsRepository {

    override suspend fun getRandomCatFacts(count: Int): Response<CatFacts> {
        return catApi.getRandomCatsFacts(count)
    }
}
