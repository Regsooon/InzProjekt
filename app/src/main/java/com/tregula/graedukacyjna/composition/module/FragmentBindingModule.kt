package com.tregula.graedukacyjna.composition.module

import com.tregula.graedukacyjna.question.QuestionFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun provideQuestionFragment(): QuestionFragment
}
