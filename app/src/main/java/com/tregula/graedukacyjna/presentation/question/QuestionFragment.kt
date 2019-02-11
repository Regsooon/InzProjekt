package com.tregula.graedukacyjna.presentation.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.InjectedFragment
import com.tregula.graedukacyjna.domain.data.test.QuestionContext
import com.tregula.graedukacyjna.view.question.QuestionView
import javax.inject.Inject

class QuestionFragment : InjectedFragment() {

    companion object {
        private const val ARG_QUESTION_CONTEXT = "arg_question_context"

        fun newInstance(questionContext: QuestionContext): QuestionFragment {
            val bundle = Bundle().apply {
                putParcelable(ARG_QUESTION_CONTEXT, questionContext)
            }
            return QuestionFragment().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var questionDescription: TextView
    private lateinit var questionContainer: QuestionView

    private var questionContext: QuestionContext? = null

    @Inject
    lateinit var presenter: QuestionContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionDescription = view.findViewById(R.id.question_text)
        questionContainer = view.findViewById(R.id.questions_container)

        presenter.attach(questionContainer)

        questionContext?.let {
            val (country, continent) = it

            questionDescription.text = getString(R.string.capitol_of_country, country.name)
            presenter.prepareData(country, continent)
            questionContainer.onAnswerClick = { capitol ->
                presenter.onAnswerChosen(capitol)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        questionContext = arguments?.getParcelable(ARG_QUESTION_CONTEXT)
    }
}
