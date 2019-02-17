package com.tregula.graedukacyjna.presentation.question.single

import com.tregula.graedukacyjna.domain.data.CapitolData
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.domain.data.test.Answer
import com.tregula.graedukacyjna.domain.data.test.Question

interface SingleQuestionContract {

    interface View {

        fun setQuestion(question: Question)

        fun disableTouches()

        fun mark(answer: Answer)

    }

    interface Presenter {

        fun prepareData(question: CountryData, answerPool: List<CountryData>)

        fun onAnswerChosen(capitolData: CapitolData)

        fun attach(view: View)

        fun detach()

    }
}