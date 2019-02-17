package com.tregula.graedukacyjna.view.question.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.domain.data.test.QuestionContext
import com.tregula.graedukacyjna.presentation.question.single.SingleQuestionFragment

class QuestionsAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val questions: MutableList<CountryData> = mutableListOf()
    private val questionPool: MutableList<CountryData> = mutableListOf()

    override fun getItem(position: Int): Fragment =
            SingleQuestionFragment.newInstance(QuestionContext(questions[position], questionPool))

    override fun getCount(): Int = questions.size

    fun setData(questionPool: List<CountryData>, questions: List<CountryData>) {
        this.questions.clear()
        this.questions.addAll(questions)
        this.questionPool.clear()
        this.questionPool.addAll(questionPool)
        notifyDataSetChanged()
    }
}