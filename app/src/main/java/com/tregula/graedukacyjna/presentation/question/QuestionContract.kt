package com.tregula.graedukacyjna.presentation.question

import com.tregula.graedukacyjna.domain.data.CapitolData
import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.domain.data.test.Answer
import com.tregula.graedukacyjna.domain.data.test.Question

interface QuestionContract {

    interface View {

        fun setQuestion(question: Question)

        fun disableTouches()

        fun mark(answer: Answer)

    }

    interface Presenter {

        fun prepareData(country: CountryData, continentData: ContinentData)

        fun onAnswerChosen(capitolData: CapitolData)

        fun attach(view: View)

        fun detach()

    }
}