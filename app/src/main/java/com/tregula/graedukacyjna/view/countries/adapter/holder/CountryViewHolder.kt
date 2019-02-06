package com.tregula.graedukacyjna.view.countries.adapter.holder

import android.view.ViewGroup
import android.widget.TextView
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.adapter.BaseViewHolder
import com.tregula.graedukacyjna.domain.data.CountryData

class CountryViewHolder(parent: ViewGroup,
                        private val onClick: (CountryData) -> Unit) : BaseViewHolder<CountryData>(parent, R.layout.country_item) {

    private val country: TextView = itemView.findViewById(R.id.country_text)
    private val capitol: TextView = itemView.findViewById(R.id.capitol_text)

    override fun bind(item: CountryData) {
        itemView.setOnClickListener {
            onClick(item)
        }
        country.text = item.name
        capitol.text = item.capitol.name
    }
}