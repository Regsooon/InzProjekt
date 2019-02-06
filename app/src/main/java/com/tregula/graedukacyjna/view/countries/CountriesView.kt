package com.tregula.graedukacyjna.view.countries

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.view.countries.adapter.CountryAdapter

class CountriesView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val SPAN_COUNT = 2
    }

    var onCountryClick: (CountryData) -> Unit = {}
    var onNavigationBack: () -> Unit = {}

    private val recyclerView: RecyclerView
    private val toolbar: Toolbar

    init {
        View.inflate(context, R.layout.countries_view, this)
        recyclerView = findViewById(R.id.recycler)
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            onNavigationBack()
        }

        recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(SPAN_COUNT, RecyclerView.VERTICAL).apply {
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
            }
        }
    }

    fun displayCountries(countries: List<CountryData>) {
        val countryAdapter = CountryAdapter(onCountryClick)
        recyclerView.adapter = countryAdapter
        countryAdapter.setItems(countries)
    }
}