package com.acioli.animalsfacts.cats_facts.domain.repository

import androidx.lifecycle.LiveData
import com.acioli.animalsfacts.cats_facts.constants.Results
import com.acioli.animalsfacts.cats_facts.domain.model.CatFacts

interface CatFactsRepository {

     fun getRandomCatFacts(count: Int? = null): LiveData<Results<CatFacts>>

}