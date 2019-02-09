package com.tregula.graedukacyjna.view.continents

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.presentation.continents.ContinentsContract
import com.tregula.graedukacyjna.view.continents.adapter.ContinentsAdapter

class ContinentsView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr),
        ContinentsContract.View {

    var onContinentClick: (ContinentData) -> Unit = {}
    var onNavigationBack: () -> Unit = {}

    private val toolbar: Toolbar
    private val recyclerView: RecyclerView
    private val continentsAdapter = ContinentsAdapter()

    init {
        View.inflate(context, R.layout.continents_view, this)
        toolbar = findViewById(R.id.toolbar)
        recyclerView = findViewById(R.id.recycler)
        toolbar.setNavigationOnClickListener {
            onNavigationBack()
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    override fun displayContinents(continents: List<ContinentData>) {
        continentsAdapter.onClick = onContinentClick
        recyclerView.adapter = continentsAdapter
        continentsAdapter.setItems(continents)
    }

    override fun displayError() {
        Toast.makeText(context, R.string.error_no_data, Toast.LENGTH_LONG).show()
    }
}