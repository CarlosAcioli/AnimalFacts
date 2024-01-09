package com.acioli.animalsfacts.dogs_service.presentation.showDogFacts

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acioli.animalsfacts.dogs_service.constants.Results
import com.acioli.animalsfacts.dogs_service.domain.repository.DogsFactsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DogFactsViewModel (
    private val dogRepo: DogsFactsRepository
): ViewModel() {

    private val _state = MutableStateFlow<List<String>>(emptyList())
    val state: StateFlow<List<String>> = _state

    fun getRandomFacts(count: Int) {

        viewModelScope.launch {

            dogRepo.getRandomDogsFacts(count).onEach { result ->

                Log.d("API", "vm: ${result.data?.facts}")
                Log.d("API", "state: ${state.value}")

                when (result) {

                    is Results.Error -> {

                        _state.value = result.data?.facts?: listOf("empty but error")

                    }

                    is Results.Success -> {

                        _state.value = result.data?.facts?: listOf("empty but success")
                        Log.d("API", "vm success: ${result.data?.facts}")
                        Log.d("API", "state success: ${state.value}")

                    }

                    is Results.Loading -> {

                        _state.value = result.data?.facts?: emptyList()

                    }

                }

            }.launchIn(this)

        }

    }


}