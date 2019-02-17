package com.tregula.graedukacyjna.presentation.continents

import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.domain.data.mode.Mode

interface ContinentsContract {

    interface View {

        fun showLoading()

        fun hideLoading()

        fun displayError()

        fun displayContinents(continents: List<ContinentData>)
    }

    interface Presenter {

        fun onContinentChosen(continent: ContinentData, mode: Mode)

        fun attach(view: View)

        fun detach()
    }
}