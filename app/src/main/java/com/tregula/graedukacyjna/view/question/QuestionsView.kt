package com.tregula.graedukacyjna.view.question

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.presentation.question.QuestionsContract
import com.tregula.graedukacyjna.view.question.adapter.QuestionsAdapter

class QuestionsView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), QuestionsContract.View {

    var onNavigationBack: () -> Unit = {}

    private val viewPager: ViewPager
    private val toolbar: Toolbar
    private val dotsIndicator: DotsIndicator

    var questionsAdapter: QuestionsAdapter? = null
        set(value) {
            value?.let { pagerAdapter ->
                field = pagerAdapter
                viewPager.adapter = pagerAdapter
                dotsIndicator.setViewPager(viewPager)
            }
        }

    init {
        View.inflate(context, R.layout.questions_view, this)
        viewPager = findViewById(R.id.view_pager)
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            onNavigationBack()
        }
        dotsIndicator = findViewById(R.id.pager_indicator)
        dotsIndicator.setDotsClickable(false)
    }

    override fun displayQuestions(questionPool: List<CountryData>, questions: List<CountryData>) {
        questionsAdapter?.setData(questionPool, questions)
    }

    override fun nextQuestion() {
        val count = questionsAdapter?.count ?: 0
        val nextId = viewPager.currentItem + 1
        if (count > nextId) {
            viewPager.setCurrentItem(nextId, true)
        }
    }
}