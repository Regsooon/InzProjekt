package com.tregula.graedukacyjna.composition.module.question

import com.tregula.graedukacyjna.presentation.question.QuestionsContract
import com.tregula.graedukacyjna.presentation.question.QuestionsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class QuestionsModule {

    @Binds
    abstract fun bindsQuestionsPresenter(questionsPresenter: QuestionsPresenter): QuestionsContract.Presenter
}