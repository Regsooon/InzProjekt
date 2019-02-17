package com.tregula.graedukacyjna.presentation.question

import com.tregula.graedukacyjna.domain.data.CountryData

interface QuestionsContract {

    interface View {

        fun displayQuestions(questionPool: List<CountryData>, questions: List<CountryData>)

        fun nextQuestion()
    }

    interface Presenter {

        fun prepareQuestions(questionPool: List<CountryData>)

        fun attach(view: View)

        fun detach()
    }
}