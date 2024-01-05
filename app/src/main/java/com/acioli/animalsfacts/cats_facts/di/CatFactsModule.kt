package com.acioli.animalsfacts.cats_facts.di

import com.acioli.animalsfacts.cats_facts.constants.Const
import com.acioli.animalsfacts.cats_facts.data.api.CatApi
import com.acioli.animalsfacts.cats_facts.data.repository.CatFactsRepositoryImpl
import com.acioli.animalsfacts.cats_facts.domain.repository.CatFactsRepository
import com.acioli.animalsfacts.cats_facts.presentation.showCatFacts.ShowCatFactsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val catFactsModule = module {
    single {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        Retrofit.Builder()
            .baseUrl(Const.CAT_FACT_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatApi::class.java)
    }
    single<CatFactsRepository> {
        CatFactsRepositoryImpl(get())
    }
    viewModel {
        ShowCatFactsViewModel(get())
    }
}