package com.tregula.graedukacyjna.navigation

import com.tregula.graedukacyjna.domain.view.data.ExternalLink

interface GameNavigation {

    fun openWebBrowser(externalLink: ExternalLink)

    fun handleOnBackPress(): Boolean

}