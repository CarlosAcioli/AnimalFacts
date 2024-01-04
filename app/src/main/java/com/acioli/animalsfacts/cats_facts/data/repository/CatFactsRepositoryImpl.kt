package com.acioli.animalsfacts.cats_facts.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.acioli.animalsfacts.cats_facts.constants.Results
import com.acioli.animalsfacts.cats_facts.data.api.CatApi
import com.acioli.animalsfacts.cats_facts.domain.model.CatFacts
import com.acioli.animalsfacts.cats_facts.domain.repository.CatFactsRepository
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatFactsRepositoryImpl(
    private val catApi: CatApi
) : CatFactsRepository {

    override suspend fun getRandomCatFacts(count: Int): LiveData<Results<List<CatFacts>>> {

        val data = MutableLiveData<Results<List<CatFacts>>>()

        catApi.getRandomCatsFacts(count).enqueue(object : Callback<List<CatFacts>> {

            override fun onResponse(
                call: Call<List<CatFacts>>,
                response: Response<List<CatFacts>>
            ) {

                data.value = Results.Success(data = response.body())

            }

            override fun onFailure(call: Call<List<CatFacts>>, t: Throwable) {

                data.value = Results.Error("$t")

            }
        })

        return data

    }

}