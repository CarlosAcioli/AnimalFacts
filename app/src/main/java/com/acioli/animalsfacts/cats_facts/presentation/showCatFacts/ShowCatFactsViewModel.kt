package com.acioli.animalsfacts.cats_facts.presentation.showCatFacts

import android.graphics.Color
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acioli.animalsfacts.cats_facts.constants.Results
import com.acioli.animalsfacts.cats_facts.domain.model.CatFacts
import com.acioli.animalsfacts.cats_facts.domain.repository.CatFactsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.scope.emptyState

class ShowCatFactsViewModel(
    private val catRepo: CatFactsRepository
) : ViewModel() {

    private val _state = MutableLiveData<Results<CatFacts>>()
    val state: LiveData<Results<CatFacts>> = _state

    fun getRandomCatFacts(): LiveData<Results<CatFacts>> {

        return catRepo.getRandomCatFacts()

    }

}