package com.acioli.animalsfacts.dogs_service.di

import com.acioli.animalsfacts.dogs_service.constants.DogConst
import com.acioli.animalsfacts.dogs_service.data.api.DogApi
import com.acioli.animalsfacts.dogs_service.data.repository.DogsFactsRepositoryImpl
import com.acioli.animalsfacts.dogs_service.domain.repository.DogsFactsRepository
import com.acioli.animalsfacts.dogs_service.presentation.showDogFacts.DogFactsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dogFactsModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(DogConst.DOG_FACT_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApi::class.java)
    }
    single<DogsFactsRepository> {
        DogsFactsRepositoryImpl(get())
    }
    viewModel<DogFactsViewModel> {
        DogFactsViewModel(get())
    }

}