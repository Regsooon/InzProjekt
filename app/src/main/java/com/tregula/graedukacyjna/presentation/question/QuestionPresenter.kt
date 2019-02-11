package com.tregula.graedukacyjna.presentation.question

import com.tregula.graedukacyjna.domain.data.CapitolData
import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.domain.data.test.Answer
import com.tregula.graedukacyjna.domain.data.test.Question
import javax.inject.Inject

class QuestionPresenter @Inject constructor() : QuestionContract.Presenter {

    companion object {
        private const val WRONG_ANSWERS_COUNT = 3
        private const val TOTAL_ANSWERS_COUNT = 4
    }

    private var view: QuestionContract.View? = null
    private var currentQuestion: CountryData? = null

    override fun prepareData(country: CountryData, continentData: ContinentData) {
        currentQuestion = country

        val questionData = continentData.countries.prepareQuestionData(country)

        val question = createQuestion(questionData)
        question?.let {
            view?.setQuestion(it)
        }
    }

    override fun onAnswerChosen(capitolData: CapitolData) {
        currentQuestion?.capitol?.let {
            if (capitolData == it) {
                view?.mark(Answer.CORRECT)
            } else {
                view?.mark(Answer.WRONG)
            }
            view?.disableTouches()
        }
    }

    override fun attach(view: QuestionContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    private fun List<CountryData>.prepareQuestionData(correctAnswer: CountryData): List<CapitolData> =
            filter { countryData ->
                countryData != correctAnswer
            }
                    .shuffled()
                    .take(WRONG_ANSWERS_COUNT)
                    .plus(correctAnswer)
                    .map { country -> country.capitol }
                    .shuffled()

    private fun createQuestion(data: List<CapitolData>): Question? =
            if (data.size >= TOTAL_ANSWERS_COUNT) {
                val (first, second, third, forth) = data
                Question(first, second, third, forth)
            } else {
                null
            }
}