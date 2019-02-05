package com.tregula.graedukacyjna.presentation.continents

import com.tregula.graedukacyjna.domain.data.ContinentData

interface ContinentsContract {

    interface View {

        fun displayError()

        fun displayContinents(continents: List<ContinentData>)
    }

    interface Presenter {

        fun onContinentChosen(continent: ContinentData)

        fun attach(view: View)

        fun detach()
    }
}