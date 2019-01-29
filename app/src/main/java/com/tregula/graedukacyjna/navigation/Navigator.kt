package com.tregula.graedukacyjna.navigation

interface Navigator<Page> {

    fun navigateTo(page: Page)

    fun handleOnBackPress(): Boolean
}