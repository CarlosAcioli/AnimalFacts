package com.acioli.animalsfacts

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.acioli.animalsfacts.cats_facts.presentation.showCatFacts.ShowCatFactsViewModel
import com.acioli.animalsfacts.cats_facts.presentation.showCatFacts.view.ShowCatFactsAdapter
import com.acioli.animalsfacts.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = getViewModel<ShowCatFactsViewModel>()
        val state = viewModel.state.value
        Log.e("TAG", "onCreate: $state")
        val dataInfo = listOf("Carlos", "Henrique", "Acioli", "dos", "Santos", "Ray", "chasray")

        binding.showCatFactsRv.layoutManager = LinearLayoutManager(this)
        binding.showCatFactsRv.setHasFixedSize(true)
        binding.showCatFactsRv.adapter = ShowCatFactsAdapter(emptyList())

        binding.GetFacts.setOnClickListener {

            val numberCatFact = binding.numberFactsEt.text.toString().toInt()
            viewModel.getRandomCatFacts(numberCatFact)

        }

        viewModel.state.observe(this) {

            binding.showCatFactsRv.adapter = ShowCatFactsAdapter(it.data)

        }


//        viewModel.getRandomCatFacts().observe(this) { result ->
//
//            when (result) {
//                is Results.Success -> {
//
//                    result.data?.let {
//                        binding.showCatFactsRv.adapter = ShowCatFactsAdapter(viewModel.state.value?: emptyList())
//                    } ?: Toast.makeText(this, "fatos estão nulos, mas sucesso", Toast.LENGTH_LONG)
//                        .show()
//
//                }
//
//                is Results.Error -> {
//
//                    Toast.makeText(
//                        this,
//                        result.message ?: "mensagem nula de erro",
//                        Toast.LENGTH_LONG
//                    ).show()
//
//                }
//
//                is Results.Loading -> Unit
//
//                else -> Unit
//            }
//
//        }

    }

}
