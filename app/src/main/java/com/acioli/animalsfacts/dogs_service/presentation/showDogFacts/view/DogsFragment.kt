package com.acioli.animalsfacts.dogs_service.presentation.showDogFacts.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.acioli.animalsfacts.R
import com.acioli.animalsfacts.databinding.FragmentDogsBinding
import com.acioli.animalsfacts.dogs_service.presentation.showDogFacts.DogFactsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DogsFragment : Fragment(R.layout.fragment_dogs) {

    private var _binding: FragmentDogsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DogFactsViewModel by sharedViewModel()
    private lateinit var dogAdapter: ShowDogFactsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDogsBinding.inflate(inflater, container, false)
        setUpRv()


        binding.GetFacts.setOnClickListener {

            if (binding.numberFactsEt.text.isNullOrBlank()) {
                Snackbar.make(it, "Hmmm, how many facts?", Snackbar.LENGTH_SHORT).show()
            } else {

                val number = binding.numberFactsEt.text.toString().toInt()
                viewModel.getRandomFacts(number)
            }



        }

        lifecycleScope.launch {

            viewModel.state.collectLatest {
                binding.showDogsRv.adapter = ShowDogFactsAdapter(it)
            }

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.showDogsRv.adapter = ShowDogFactsAdapter(viewModel.state.value)


    }

    private fun setUpRv() {
        dogAdapter = ShowDogFactsAdapter(emptyList())
        binding.showDogsRv.apply {
            adapter = dogAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}