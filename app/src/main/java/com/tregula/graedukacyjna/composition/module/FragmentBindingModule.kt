package com.tregula.graedukacyjna.composition.module

import com.tregula.graedukacyjna.composition.module.continents.ContinentsModule
import com.tregula.graedukacyjna.composition.module.question.QuestionsModule
import com.tregula.graedukacyjna.composition.module.question.SingleQuestionModule
import com.tregula.graedukacyjna.presentation.AreaDetailFragment
import com.tregula.graedukacyjna.presentation.ScoreFragment
import com.tregula.graedukacyjna.presentation.WebBrowserFragment
import com.tregula.graedukacyjna.presentation.continents.ContinentsFragment
import com.tregula.graedukacyjna.presentation.countries.CountriesFragment
import com.tregula.graedukacyjna.presentation.mode.ModeFragment
import com.tregula.graedukacyjna.presentation.question.QuestionsFragment
import com.tregula.graedukacyjna.presentation.question.single.SingleQuestionFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = [SingleQuestionModule::class])
    abstract fun provideQuestionFragment(): SingleQuestionFragment

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

    @ContributesAndroidInjector(modules = [QuestionsModule::class])
    abstract fun provideQuestionsFragment(): QuestionsFragment

    @ContributesAndroidInjector
    abstract fun prvodeSocoreFragment(): ScoreFragment
}
