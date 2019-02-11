package com.tregula.graedukacyjna.view.question

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.domain.data.CapitolData
import com.tregula.graedukacyjna.domain.data.test.Answer
import com.tregula.graedukacyjna.domain.data.test.Question

class QuestionView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var onAnswerClick: (capitolData: CapitolData) -> Unit = {}

    private val firstAnswer: Button
    private val secondAnswer: Button
    private val thirdAnswer: Button
    private val forthAnswer: Button

    private val buttons: List<Button>

    private var chosen: View? = null

    init {
        inflate(context, R.layout.question_view, this)
        firstAnswer = findViewById(R.id.first_answer)
        secondAnswer = findViewById(R.id.second_answer)
        thirdAnswer = findViewById(R.id.third_answer)
        forthAnswer = findViewById(R.id.forth_answer)

        buttons = listOf(firstAnswer, secondAnswer, thirdAnswer, forthAnswer)
    }

    fun setData(question: Question) {
        firstAnswer.setupWithCapitol(question.first)
        secondAnswer.setupWithCapitol(question.second)
        thirdAnswer.setupWithCapitol(question.third)
        forthAnswer.setupWithCapitol(question.forth)
    }

    fun mark(answer: Answer) {
        buttons.firstOrNull {
            it == chosen
        }?.let {
            when (answer) {
                Answer.CORRECT -> it.setBackgroundColor(Color.GREEN)
                Answer.WRONG -> it.setBackgroundColor(Color.RED)
            }
        }
    }

    fun disableTouches() {
        buttons.forEach { button ->
            button.isFocusableInTouchMode = false
            button.isClickable = false
            button.setOnClickListener { }
        }
    }

    private fun Button.setupWithCapitol(capitol: CapitolData) {
        text = capitol.name
        setOnClickListener {
            chosen = it
            onAnswerClick(capitol)
        }
    }
}
