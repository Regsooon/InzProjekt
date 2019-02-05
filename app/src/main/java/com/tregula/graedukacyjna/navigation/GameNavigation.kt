package com.tregula.graedukacyjna.navigation

import com.tregula.graedukacyjna.domain.data.mode.Mode
import com.tregula.graedukacyjna.domain.view.ExternalLink

interface GameNavigation {

    fun openMainPage()

    fun openWebBrowser(externalLink: ExternalLink)

    fun openContinents(mode: Mode)

    fun handleOnBackPress(): Boolean

}