package com.acioli.animalsfacts.dogs_service.domain.repository

import com.acioli.animalsfacts.dogs_service.constants.Results
import com.acioli.animalsfacts.dogs_service.domain.model.DogFacts
import kotlinx.coroutines.flow.Flow

interface DogsFactsRepository {

    fun getRandomDogsFacts(count: Int): Flow<Results<DogFacts>>

}