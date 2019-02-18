package com.tregula.graedukacyjna.navigation

import androidx.fragment.app.Fragment
import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.domain.data.mode.Mode
import com.tregula.graedukacyjna.domain.view.AreaDetail
import com.tregula.graedukacyjna.domain.view.ExternalLink
import com.tregula.graedukacyjna.presentation.AreaDetailFragment
import com.tregula.graedukacyjna.presentation.ScoreFragment
import com.tregula.graedukacyjna.presentation.WebBrowserFragment
import com.tregula.graedukacyjna.presentation.continents.ContinentsFragment
import com.tregula.graedukacyjna.presentation.countries.CountriesFragment
import com.tregula.graedukacyjna.presentation.mode.ModeFragment
import com.tregula.graedukacyjna.presentation.question.QuestionsFragment
import javax.inject.Inject

class FragmentGameNavigation @Inject constructor(private val navigator: Navigator<Fragment>) : GameNavigation {

    companion object {
        private val QUESTIONS_TAG = QuestionsFragment::class.java.simpleName
    }

    override fun openMainPage() =
            navigator.startWith(ModeFragment())

    override fun openWebBrowser(externalLink: ExternalLink) =
            navigator.navigateTo(WebBrowserFragment.newInstance(externalLink))

    override fun openContinents(mode: Mode) =
            navigator.navigateTo(ContinentsFragment.newInstance(mode))

    override fun openCountries(continent: ContinentData) =
            navigator.navigateTo(CountriesFragment.newInstance(continent))

    override fun openAreaDetail(detail: AreaDetail) =
            navigator.navigateTo(AreaDetailFragment.newInstance(detail))

    override fun openQuestions(questionPool: List<CountryData>) =
            navigator.navigateTo(QuestionsFragment.newInstance(questionPool), QUESTIONS_TAG)

    override fun openScore(score: Int) =
            navigator.navigateTo(ScoreFragment.newInstance(score))

    override fun handleOnBackPress(): Boolean =
            navigator.handleOnBackPress()
}