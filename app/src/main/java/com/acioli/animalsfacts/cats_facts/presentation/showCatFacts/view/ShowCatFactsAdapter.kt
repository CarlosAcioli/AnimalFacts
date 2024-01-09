package com.acioli.animalsfacts.cats_facts.presentation.showCatFacts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acioli.animalsfacts.R

class ShowCatFactsAdapter(
     val data: List<String>
) : RecyclerView.Adapter<ShowCatFactsAdapter.ShowCatFactsViewHolder>() {


    class ShowCatFactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val catFact: TextView = itemView.findViewById(R.id.showCatFactTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCatFactsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cat_fact_item, parent, false)
        return ShowCatFactsViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ShowCatFactsViewHolder, position: Int) {

        val catFact = data[position]

        holder.catFact.text = catFact

    }

}