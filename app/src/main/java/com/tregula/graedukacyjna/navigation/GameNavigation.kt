package com.tregula.graedukacyjna.navigation

import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.domain.data.mode.Mode
import com.tregula.graedukacyjna.domain.view.AreaDetail
import com.tregula.graedukacyjna.domain.view.ExternalLink

interface GameNavigation {

    fun openMainPage()

    fun openWebBrowser(externalLink: ExternalLink)

    fun openContinents(mode: Mode)

    fun openCountries(continent: ContinentData)

    fun openAreaDetail(detail: AreaDetail)

    fun openQuestions(questionPool: List<CountryData>)

    fun openScore(score: Int)

    fun handleOnBackPress(): Boolean

}