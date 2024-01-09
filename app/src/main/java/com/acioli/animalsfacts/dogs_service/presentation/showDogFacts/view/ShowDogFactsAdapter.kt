package com.acioli.animalsfacts.dogs_service.presentation.showDogFacts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acioli.animalsfacts.R

class ShowDogFactsAdapter(
     val data: List<String>
) : RecyclerView.Adapter<ShowDogFactsAdapter.ShowDogFactsViewHolder>() {

    class ShowDogFactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogFact: TextView = itemView.findViewById(R.id.showDogFactTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowDogFactsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.dog_fact_item, parent, false)
        return ShowDogFactsViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ShowDogFactsViewHolder, position: Int) {

        val dogFact = data[position]

        holder.dogFact.text = dogFact

    }

}