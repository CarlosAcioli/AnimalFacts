package com.acioli.animalsfacts.cats_facts.presentation.showCatFacts

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
                _state.postValue(response.body())
            } else {
                Log.e("erro", "error: ${response.message()}", )
            }

        }

    }

}

//try {
//    val answer = catRepo.getRandomCatFacts()
//    val foo = answer.body()?.data!!
//
//    if (answer.isSuccessful) {
//        emit(Results.Success(data = foo))
//        _state.value = foo
//    } else {
//        emit(Results.Error("erro ao acessar fatos de gatos"))
//    }
//
//} catch (e: ConnectException) {
//
//    e.printStackTrace()
//    emit(Results.Error("falha na comunicação da api"))
//
//} catch (e: Exception) {
//
//    e.printStackTrace()
//    emit(Results.Error("erro"))
//
//}