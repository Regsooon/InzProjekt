package com.tregula.graedukacyjna.composition.module

import com.tregula.graedukacyjna.presentation.question.QuestionFragment
import com.tregula.graedukacyjna.view.AreaDetailFragment
import com.tregula.graedukacyjna.view.WebBrowserFragment
import com.tregula.graedukacyjna.presentation.mode.ModeFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun provideQuestionFragment(): QuestionFragment

    @ContributesAndroidInjector
    abstract fun providesAreaDetailFragment(): AreaDetailFragment

    @ContributesAndroidInjector
    abstract fun providesWebBrowserFragment(): WebBrowserFragment

    @ContributesAndroidInjector
    abstract fun provideModeFragmet(): ModeFragment
}
