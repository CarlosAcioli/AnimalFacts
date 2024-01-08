package com.acioli.animalsfacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.acioli.animalsfacts.cats_facts.presentation.showCatFacts.view.CatsFragment
import com.acioli.animalsfacts.databinding.ActivityMainBinding
import com.acioli.animalsfacts.dogs_service.presentation.showDogFacts.view.DogsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(CatsFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.cats -> {

                    replaceFragment(CatsFragment())

                }

                R.id.dogs -> {

                    replaceFragment(DogsFragment())

                }

            }

            true

        }


    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }

}
