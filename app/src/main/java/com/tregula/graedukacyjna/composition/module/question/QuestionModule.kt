package com.tregula.graedukacyjna.composition.module.question

import com.tregula.graedukacyjna.presentation.question.QuestionContract
import com.tregula.graedukacyjna.presentation.question.QuestionPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class QuestionModule {

    @Binds
    abstract fun bindsQuestionPreseter(questionPresenter: QuestionPresenter): QuestionContract.Presenter
}