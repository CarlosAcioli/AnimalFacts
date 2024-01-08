package com.acioli.animalsfacts.dogs_service.data.dto

import com.acioli.animalsfacts.dogs_service.domain.model.DogFacts

data class DogFactsDto(
    val facts: List<String>,
    val isSuccess: Boolean
){

    fun toDogFacts(): DogFacts {
        return DogFacts(
            facts = facts
        )
    }

}
