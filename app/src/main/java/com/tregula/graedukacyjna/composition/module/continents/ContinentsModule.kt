package com.tregula.graedukacyjna.composition.module.continents

import com.tregula.graedukacyjna.presentation.continents.ContinentsContract
import com.tregula.graedukacyjna.presentation.continents.ContinentsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ContinentsModule {

    @Binds
    abstract fun bindsContinentsPresenter(presenter: ContinentsPresenter): ContinentsContract.Presenter
}