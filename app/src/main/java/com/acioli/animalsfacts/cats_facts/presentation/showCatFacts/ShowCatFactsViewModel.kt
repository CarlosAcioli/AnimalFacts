package com.acioli.animalsfacts.cats_facts.presentation.showCatFacts

import android.net.http.HttpException
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acioli.animalsfacts.cats_facts.domain.model.CatFacts
import com.acioli.animalsfacts.cats_facts.domain.repository.CatFactsRepository
import kotlinx.coroutines.launch

class ShowCatFactsViewModel(
    private val catRepo: CatFactsRepository
) : ViewModel() {

    private val _state = MutableLiveData<CatFacts>()
    val state: LiveData<CatFacts> = _state

    private val _numState = MutableLiveData<Int>()
    val numState: LiveData<Int> = _numState
    fun getRandomCatFacts(count: Int) = viewModelScope.launch {

        _numState.postValue(count)

        catRepo.getRandomCatFacts(count).let { response ->

            if (response.isSuccessful) {
                _state.value = response.body()
            } else {
                Log.e("erro", "error: ${response.message()}", )
            }

        }

    }

}