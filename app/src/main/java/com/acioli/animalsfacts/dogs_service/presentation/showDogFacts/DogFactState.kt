package com.acioli.animalsfacts.dogs_service.presentation.showDogFacts

data class DogFactState(
    val facts: List<String> = emptyList(),
    val isLoading: Boolean = false
)
