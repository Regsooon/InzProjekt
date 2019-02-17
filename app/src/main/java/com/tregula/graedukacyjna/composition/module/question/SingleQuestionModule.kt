package com.tregula.graedukacyjna.composition.module.question

import com.tregula.graedukacyjna.presentation.question.single.SingleQuestionContract
import com.tregula.graedukacyjna.presentation.question.single.SingleQuestionPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class SingleQuestionModule {

    @Binds
    abstract fun bindsQuestionPreseter(singleQuestionPresenter: SingleQuestionPresenter): SingleQuestionContract.Presenter
}