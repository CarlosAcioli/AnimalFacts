package com.acioli.animalsfacts.cats_facts.presentation.showCatFacts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.acioli.animalsfacts.cats_facts.presentation.showCatFacts.ShowCatFactsViewModel
import com.acioli.animalsfacts.databinding.FragmentCatsBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class CatsFragment : Fragment() {

    private var _binding: FragmentCatsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ShowCatFactsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatsBinding.inflate(inflater, container, false)


        val viewModel = getViewModel<ShowCatFactsViewModel>()


        binding.showCatFactsRv.layoutManager = LinearLayoutManager(context)
        binding.showCatFactsRv.setHasFixedSize(true)
        binding.showCatFactsRv.adapter = ShowCatFactsAdapter(emptyList())

        binding.GetFacts.setOnClickListener {

            val numberCatFact = binding.numberFactsEt.text.toString().toInt()
            viewModel.getRandomCatFacts(numberCatFact)

        }

        viewModel.state.observe(this) {

            binding.showCatFactsRv.adapter = ShowCatFactsAdapter(it.data)

        }

        return binding.root

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}