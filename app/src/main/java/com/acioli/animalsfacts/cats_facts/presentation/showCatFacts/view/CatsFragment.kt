package com.acioli.animalsfacts.cats_facts.presentation.showCatFacts.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.acioli.animalsfacts.R
import com.acioli.animalsfacts.cats_facts.presentation.showCatFacts.ShowCatFactsViewModel
import com.acioli.animalsfacts.databinding.FragmentCatsBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.log

class CatsFragment : Fragment(R.layout.fragment_cats) {

    private var _binding: FragmentCatsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ShowCatFactsViewModel by sharedViewModel()
    private lateinit var catAdapter: ShowCatFactsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatsBinding.inflate(inflater, container, false)
        setUpRv()


        binding.GetFacts.setOnClickListener {

            if(binding.numberFactsEt.text.isNullOrBlank()) {
                Snackbar.make(it, "Hmmm, how many facts?", Snackbar.LENGTH_SHORT).show()
            } else {

                val numberCatFact = binding.numberFactsEt.text.toString().toInt()
                viewModel.getRandomCatFacts(numberCatFact)
            }



        }

        viewModel.state.observe(viewLifecycleOwner) {

            binding.showCatFactsRv.adapter = ShowCatFactsAdapter(it.data)

        }

        return binding.root

    }

    private fun setUpRv() {
        catAdapter = ShowCatFactsAdapter(emptyList())
        binding.showCatFactsRv.apply {
            adapter = catAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}