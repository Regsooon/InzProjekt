package com.tregula.graedukacyjna.navigation

import com.tregula.graedukacyjna.domain.view.data.ExternalLink

interface GameNavigation {

    fun openMainPage()

    fun openWebBrowser(externalLink: ExternalLink)

    fun openContinents()

    fun handleOnBackPress(): Boolean

}