package com.tregula.graedukacyjna.presentation.question

import com.tregula.graedukacyjna.concurrent.GameSchedulers
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.domain.data.test.Answer
import com.tregula.graedukacyjna.domain.data.test.AnsweredQuestion
import com.tregula.graedukacyjna.navigation.GameNavigation
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class QuestionsPresenter @Inject constructor(private val gameNavigation: GameNavigation,
                                             private val observableAnswer: Observable<AnsweredQuestion>,
                                             private val gameSchedulers: GameSchedulers) : QuestionsContract.Presenter {

    companion object {
        private const val QUESTION_COUNT = 10
        private const val ANSWER_DELAY = 1L
    }

    private var view: QuestionsContract.View? = null
    private val disposables = CompositeDisposable()
    private val questions: MutableList<CountryData> = mutableListOf()
    private val answerMap: MutableMap<CountryData, Answer> = mutableMapOf()

    override fun prepareQuestions(questionPool: List<CountryData>) {
        questions.clear()
        questions.addAll(questionPool.shuffled().take(QUESTION_COUNT))
        view?.displayQuestions(questionPool, questions)
    }

    override fun attach(view: QuestionsContract.View) {
        this.view = view
        val disposable = observableAnswer
                .delay(ANSWER_DELAY, TimeUnit.SECONDS)
                .subscribeOn(gameSchedulers.io())
                .observeOn(gameSchedulers.main())
                .subscribe(::onQuestionAnswer)
        disposables.add(disposable)
    }

    override fun detach() {
        view = null
        if (disposables.isDisposed.not()) {
            disposables.dispose()
        }
    }

    private fun onQuestionAnswer(answeredQuestion: AnsweredQuestion) {
        answerMap[answeredQuestion.country] = answeredQuestion.answer
        val index = questions.indexOf(answeredQuestion.country)
        if (index == questions.lastIndex) {
            gameNavigation.openScore(500)
        } else {
            view?.nextQuestion()
        }
    }
}