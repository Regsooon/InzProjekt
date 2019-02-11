package com.tregula.graedukacyjna.composition.module

import com.tregula.graedukacyjna.composition.module.continents.ContinentsModule
import com.tregula.graedukacyjna.composition.module.question.QuestionModule
import com.tregula.graedukacyjna.presentation.AreaDetailFragment
import com.tregula.graedukacyjna.presentation.WebBrowserFragment
import com.tregula.graedukacyjna.presentation.continents.ContinentsFragment
import com.tregula.graedukacyjna.presentation.countries.CountriesFragment
import com.tregula.graedukacyjna.presentation.mode.ModeFragment
import com.tregula.graedukacyjna.presentation.question.QuestionFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = [QuestionModule::class])
    abstract fun provideQuestionFragment(): QuestionFragment

    @ContributesAndroidInjector
    abstract fun providesAreaDetailFragment(): AreaDetailFragment

    @ContributesAndroidInjector
    abstract fun providesWebBrowserFragment(): WebBrowserFragment

    @ContributesAndroidInjector
    abstract fun provideModeFragmet(): ModeFragment

    @ContributesAndroidInjector(modules = [ContinentsModule::class])
    abstract fun provideContinentsFragment(): ContinentsFragment

    @ContributesAndroidInjector
    abstract fun provideCountriesFragment(): CountriesFragment
}
