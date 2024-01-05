package com.acioli.animalsfacts

import android.app.Application
import com.acioli.animalsfacts.cats_facts.di.catFactsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(catFactsModule)
        }

    }

}