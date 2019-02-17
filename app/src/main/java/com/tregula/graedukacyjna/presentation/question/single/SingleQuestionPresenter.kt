package com.tregula.graedukacyjna.presentation.question.single

import com.tregula.graedukacyjna.concurrent.bus.AnswerSender
import com.tregula.graedukacyjna.domain.data.CapitolData
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.domain.data.test.Answer
import com.tregula.graedukacyjna.domain.data.test.Question
import javax.inject.Inject

class SingleQuestionPresenter @Inject constructor(private val answerSender: AnswerSender) : SingleQuestionContract.Presenter {

    companion object {
        private const val WRONG_ANSWERS_COUNT = 3
        private const val TOTAL_ANSWERS_COUNT = 4
    }

    private var view: SingleQuestionContract.View? = null
    private var currentQuestion: CountryData? = null

    override fun prepareData(question: CountryData, answerPool: List<CountryData>) {
        currentQuestion = question

        val questionData = answerPool.prepareQuestionData(question)

        val preparedQuestion = createQuestion(questionData)
        preparedQuestion?.let {
            view?.setQuestion(it)
        }
    }

    override fun onAnswerChosen(capitolData: CapitolData) {
        currentQuestion?.let { question ->
            val answer = if (capitolData == question.capitol) {
                Answer.CORRECT
            } else {
                Answer.WRONG
            }
            view?.mark(answer)
            view?.disableTouches()
            answerSender.sendAnswer(question, answer)
        }
    }

    override fun attach(view: SingleQuestionContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    private fun List<CountryData>.prepareQuestionData(correctAnswer: CountryData): List<CapitolData> =
            filter { it != correctAnswer }
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