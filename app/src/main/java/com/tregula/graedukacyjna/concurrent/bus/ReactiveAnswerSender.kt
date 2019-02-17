package com.tregula.graedukacyjna.concurrent.bus

import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.domain.data.test.Answer
import com.tregula.graedukacyjna.domain.data.test.AnsweredQuestion
import io.reactivex.subjects.Subject
import javax.inject.Inject

class ReactiveAnswerSender @Inject constructor(private val dispatcher: Subject<AnsweredQuestion>) : AnswerSender {

    override fun sendAnswer(currentQuestion: CountryData, answer: Answer) =
            dispatcher.onNext(AnsweredQuestion(currentQuestion, answer))

}