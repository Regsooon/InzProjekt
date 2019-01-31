package com.tregula.graedukacyjna.presentation.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.InjectedFragment

class QuestionFragment : InjectedFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }
}
