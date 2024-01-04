package com.acioli.animalsfacts.cats_facts.presentation.showCatFacts

import com.acioli.animalsfacts.cats_facts.domain.model.CatFacts

data class CatFactsState(
    val catFacts: List<CatFacts> = emptyList(),
    val isLoading: Boolean = false
)
