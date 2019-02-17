package com.tregula.graedukacyjna.composition.module.question

import com.tregula.graedukacyjna.domain.data.test.AnsweredQuestion
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import javax.inject.Singleton

@Module
class QuestionBusModule {

    @Provides
    @Singleton
    fun provideQuestionAnswerSubject(): Subject<AnsweredQuestion> = PublishSubject.create()

    @Provides
    fun provideObservableAnsweredQuestion(subject: Subject<AnsweredQuestion>): Observable<AnsweredQuestion> = subject

}