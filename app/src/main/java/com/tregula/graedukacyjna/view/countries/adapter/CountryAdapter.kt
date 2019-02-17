package com.tregula.graedukacyjna.view.countries.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.view.countries.adapter.holder.CountryViewHolder

class CountryAdapter : RecyclerView.Adapter<CountryViewHolder>() {

    var onClick: (CountryData) -> Unit = {}
    private val items: MutableList<CountryData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder =
            CountryViewHolder(parent, onClick)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) =
            holder.bind(items[position])

    fun setItems(countries: List<CountryData>) {
        items.clear()
        items.addAll(countries)
        notifyDataSetChanged()
    }
}