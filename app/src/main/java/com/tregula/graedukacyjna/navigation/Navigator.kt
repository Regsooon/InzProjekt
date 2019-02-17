package com.tregula.graedukacyjna.navigation

interface Navigator<Page> {

    fun startWith(page: Page)

    fun navigateTo(page: Page, tag: String? = null)

    fun handleOnBackPress(): Boolean
}