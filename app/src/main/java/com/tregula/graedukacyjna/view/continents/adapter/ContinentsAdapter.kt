package com.tregula.graedukacyjna.view.continents.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.view.continents.adapter.holder.ContinentViewHolder

class ContinentsAdapter : RecyclerView.Adapter<ContinentViewHolder>() {

    var onClick: (ContinentData) -> Unit = {}
    private val items: MutableList<ContinentData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContinentViewHolder =
            ContinentViewHolder(parent, onClick)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ContinentViewHolder, position: Int) =
            holder.bind(items[position])

    fun setItems(continents: List<ContinentData>) {
        items.clear()
        items.addAll(continents)
        notifyDataSetChanged()
    }
}