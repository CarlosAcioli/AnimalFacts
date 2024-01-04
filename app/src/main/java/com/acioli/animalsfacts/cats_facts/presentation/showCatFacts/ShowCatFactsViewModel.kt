package com.acioli.animalsfacts.cats_facts.presentation.showCatFacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acioli.animalsfacts.cats_facts.constants.Results
import com.acioli.animalsfacts.cats_facts.domain.model.CatFacts
import com.acioli.animalsfacts.cats_facts.domain.repository.CatFactsRepository
import kotlinx.coroutines.launch

class ShowCatFactsViewModel (
    private val catRepo: CatFactsRepository
): ViewModel() {

    private val _state = MutableLiveData<List<CatFacts>>(emptyList())
    val state: LiveData<List<CatFacts>> = _state

    private val _catFactsState = MutableLiveData<CatFactsState>(CatFactsState())
    val catFactState: LiveData<CatFactsState> = _catFactsState

    fun getRandomCatFacts(count: Int) {

        viewModelScope.launch {

            val value = catRepo.getRandomCatFacts(count).value!!

            when (value) {

                is Results.Error -> {
                    _state.value = value.data!!
                }

                is Results.Success -> {
                    _state.value = value.data!!
                }

                is Results.Loading -> {

                }

            }

        }

    }

}