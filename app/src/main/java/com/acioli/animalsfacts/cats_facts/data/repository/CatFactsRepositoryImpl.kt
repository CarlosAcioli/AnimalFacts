package com.acioli.animalsfacts.cats_facts.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.acioli.animalsfacts.cats_facts.constants.Results
import com.acioli.animalsfacts.cats_facts.data.api.CatApi
import com.acioli.animalsfacts.cats_facts.domain.model.CatFacts
import com.acioli.animalsfacts.cats_facts.domain.repository.CatFactsRepository
import java.net.ConnectException

class CatFactsRepositoryImpl(
    private val catApi: CatApi
) : CatFactsRepository {

    override fun getRandomCatFacts(count: Int?): LiveData<Results<CatFacts>> = liveData<Results<CatFacts>> {

            try {
                val answer = catApi.getRandomCatsFacts(3)

                if (answer.isSuccessful) {
                    emit(Results.Success(data = answer.body()))
                } else {
                    emit(Results.Error("erro ao acessar fatos de gatos"))
                }

            } catch (e: ConnectException) {

                e.printStackTrace()
                emit(Results.Error("falha na comunicação da api"))

            } catch (e: Exception) {

                e.printStackTrace()
                emit(Results.Error("erro"))

            }

    }

}
