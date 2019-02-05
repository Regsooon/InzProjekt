package com.tregula.graedukacyjna.navigation

import androidx.fragment.app.Fragment
import com.tregula.graedukacyjna.domain.data.mode.Mode
import com.tregula.graedukacyjna.domain.view.ExternalLink
import com.tregula.graedukacyjna.presentation.continents.ContinentsFragment
import com.tregula.graedukacyjna.view.WebBrowserFragment
import com.tregula.graedukacyjna.presentation.mode.ModeFragment
import javax.inject.Inject

class FragmentGameNavigation @Inject constructor(private val navigator: Navigator<Fragment>) : GameNavigation {

    override fun openMainPage() =
            navigator.startWith(ModeFragment())

    override fun openWebBrowser(externalLink: ExternalLink) =
            navigator.navigateTo(WebBrowserFragment.newInstance(externalLink))

    override fun openContinents(mode: Mode) =
            navigator.navigateTo(ContinentsFragment.newInstance(mode))

    override fun handleOnBackPress(): Boolean =
            navigator.handleOnBackPress()
}