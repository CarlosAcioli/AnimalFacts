package com.acioli.animalsfacts.dogs_service.presentation.showDogFacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acioli.animalsfacts.dogs_service.constants.Results
import com.acioli.animalsfacts.dogs_service.domain.repository.DogsFactsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DogFactsViewModel (
    private val dogRepo: DogsFactsRepository
): ViewModel() {

    private val _dogState = MutableStateFlow<DogFactState>(DogFactState())
    val dogState: StateFlow<DogFactState> = _dogState

    fun getRandomFacts(count: Int) {

        viewModelScope.launch {

            dogRepo.getRandomDogsFacts(count).onEach { result ->

                when (result) {

                    is Results.Error -> {

                        _dogState.value = dogState.value.copy(
                            facts = result.data?.facts?: listOf("Hi", "Hello"),
                            isLoading = true
                        )

                    }

                    is Results.Success -> {

                        _dogState.value = dogState.value.copy(
                            facts = result.data?.facts?: listOf("Suc"),
                            isLoading = false
                        )

                    }

                    is Results.Loading -> {

                        _dogState.value = dogState.value.copy(
                            facts = result.data?.facts?: listOf("Load"),
                            isLoading = true
                        )

                    }

                }

            }

        }

    }


}