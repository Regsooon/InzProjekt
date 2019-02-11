package com.tregula.graedukacyjna.presentation.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.InjectedFragment
import com.tregula.graedukacyjna.view.question.QuestionView

class QuestionFragment : InjectedFragment() {

    private lateinit var questionDescription: TextView
    private lateinit var questionContainer: QuestionView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionDescription = view.findViewById(R.id.question_text)
        questionContainer = view.findViewById(R.id.questions_container)
    }
}
