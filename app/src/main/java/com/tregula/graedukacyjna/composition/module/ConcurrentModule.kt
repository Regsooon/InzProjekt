package com.tregula.graedukacyjna.composition.module

import com.tregula.graedukacyjna.composition.module.question.QuestionBusModule
import com.tregula.graedukacyjna.concurrent.EducationGameSchedulers
import com.tregula.graedukacyjna.concurrent.GameSchedulers
import com.tregula.graedukacyjna.concurrent.bus.AnswerSender
import com.tregula.graedukacyjna.concurrent.bus.ReactiveAnswerSender
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [QuestionBusModule::class])
abstract class ConcurrentModule {

    @Binds
    @Singleton
    abstract fun bindsSchedulers(educationGameSchedulers: EducationGameSchedulers): GameSchedulers

    @Binds
    @Singleton
    abstract fun bindsAnswerSender(reactiveAnswerSender: ReactiveAnswerSender): AnswerSender
}
