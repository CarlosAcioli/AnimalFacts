package com.acioli.animalsfacts.dogs_service.presentation.showDogFacts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acioli.animalsfacts.databinding.FragmentDogsBinding

class DogsFragment : Fragment() {

    private var _binding: FragmentDogsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogsBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}