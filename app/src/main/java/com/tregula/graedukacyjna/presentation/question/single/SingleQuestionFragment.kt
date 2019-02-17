package com.tregula.graedukacyjna.presentation.question.single

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.InjectedFragment
import com.tregula.graedukacyjna.domain.data.test.QuestionContext
import com.tregula.graedukacyjna.view.question.SingleQuestionView
import javax.inject.Inject

class SingleQuestionFragment : InjectedFragment() {

    companion object {
        private const val ARG_QUESTION_CONTEXT = "arg_question_context"

        fun newInstance(questionContext: QuestionContext): SingleQuestionFragment {
            val bundle = Bundle().apply {
                putParcelable(ARG_QUESTION_CONTEXT, questionContext)
            }
            return SingleQuestionFragment().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var questionDescription: TextView
    private lateinit var singleQuestionContainer: SingleQuestionView

    private var questionContext: QuestionContext? = null

    @Inject
    lateinit var presenter: SingleQuestionContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_single_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionDescription = view.findViewById(R.id.question_text)
        singleQuestionContainer = view.findViewById(R.id.questions_container)

        presenter.attach(singleQuestionContainer)

        questionContext?.let {
            val (question, questionPool) = it

            questionDescription.text = getString(R.string.capitol_of_country, question.name)
            presenter.prepareData(question, questionPool)
            singleQuestionContainer.onAnswerClick = { capitol ->
                presenter.onAnswerChosen(capitol)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        questionContext = arguments?.getParcelable(ARG_QUESTION_CONTEXT)
    }
}
