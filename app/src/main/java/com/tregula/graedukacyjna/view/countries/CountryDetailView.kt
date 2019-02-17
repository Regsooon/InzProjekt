package com.tregula.graedukacyjna.view.countries

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.domain.view.CountryDetail

class CountryDetailView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val countryText: TextView
    private val capitolText: TextView

    init {
        View.inflate(context, R.layout.country_detail_view, this)
        countryText = findViewById(R.id.country_text)
        capitolText = findViewById(R.id.capitol_text)
        countryText.paintFlags = countryText.paintFlags.or(Paint.UNDERLINE_TEXT_FLAG)
        capitolText.paintFlags = capitolText.paintFlags.or(Paint.UNDERLINE_TEXT_FLAG)
    }

    fun setData(countryDetail: CountryDetail, onElementClick: (url: String, title: String) -> Unit) {
        val countryTitle = context.getString(R.string.country_details, countryDetail.countryName)
        val capitolTitle = context.getString(R.string.capitol_details, countryDetail.capitolName)

        countryText.text = countryTitle
        capitolText.text = capitolTitle

        countryText.setOnClickListener {
            onElementClick(countryDetail.countryWiki, countryTitle)
        }
        capitolText.setOnClickListener {
            onElementClick(countryDetail.capitolWiki, capitolTitle)
        }
    }
}