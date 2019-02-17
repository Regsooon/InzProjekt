package com.tregula.graedukacyjna.view.continents.adapter.holder

import android.view.ViewGroup
import android.widget.TextView
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.adapter.BaseViewHolder
import com.tregula.graedukacyjna.domain.data.ContinentData

class ContinentViewHolder(parent: ViewGroup,
                          private val onClick: (ContinentData) -> Unit)
    : BaseViewHolder<ContinentData>(parent, R.layout.continent_item) {

    private val continentName: TextView = itemView.findViewById(R.id.continent_name)

    override fun bind(item: ContinentData) {
        itemView.setOnClickListener {
            onClick(item)
        }
        continentName.text = item.name
    }
}