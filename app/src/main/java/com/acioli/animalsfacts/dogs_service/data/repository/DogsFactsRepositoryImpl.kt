package com.acioli.animalsfacts.dogs_service.data.repository

import android.util.Log
import com.acioli.animalsfacts.dogs_service.constants.Results
import com.acioli.animalsfacts.dogs_service.data.api.DogApi
import com.acioli.animalsfacts.dogs_service.domain.model.DogFacts
import com.acioli.animalsfacts.dogs_service.domain.repository.DogsFactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class DogsFactsRepositoryImpl (
    private val dogApi: DogApi
): DogsFactsRepository {

    override fun getRandomDogsFacts(count: Int): Flow<Results<DogFacts>> {

        return flow {

            emit(Results.Loading())

            try {

                val dogsFacts = dogApi.getRandomDogsFacts(count).toDogFacts()
                Log.e("API", "repo impl: $dogsFacts", )

                emit(Results.Success(data = dogsFacts))

            } catch (e: IOException) {

                emit(Results.Error(message = "Não foi possível alcançar o servidor, cheque sua internet!"))

            } catch (e: HttpException) {

                emit(Results.Error(message = "Não foi possível recuperar fatos dos dogs... aff"))

            }

        }

    }
}