package com.tregula.graedukacyjna.view.question

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.domain.data.CapitolData
import com.tregula.graedukacyjna.domain.data.test.Answer
import com.tregula.graedukacyjna.domain.data.test.Question
import com.tregula.graedukacyjna.presentation.question.QuestionContract

class QuestionView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), QuestionContract.View {

    var onAnswerClick: (capitol: CapitolData) -> Unit = {}

    private val firstAnswer: TextView
    private val secondAnswer: TextView
    private val thirdAnswer: TextView
    private val forthAnswer: TextView

    private val buttons: List<TextView>

    private var chosen: View? = null

    init {
        inflate(context, R.layout.question_view, this)
        firstAnswer = findViewById(R.id.first_answer)
        secondAnswer = findViewById(R.id.second_answer)
        thirdAnswer = findViewById(R.id.third_answer)
        forthAnswer = findViewById(R.id.forth_answer)

        buttons = listOf(firstAnswer, secondAnswer, thirdAnswer, forthAnswer)
    }

    override fun setQuestion(question: Question) {
        firstAnswer.setupWithCapitol(question.first)
        secondAnswer.setupWithCapitol(question.second)
        thirdAnswer.setupWithCapitol(question.third)
        forthAnswer.setupWithCapitol(question.forth)
    }

    override fun mark(answer: Answer) {
        buttons.firstOrNull {
            it == chosen
        }?.let {
            when (answer) {
                Answer.CORRECT -> it.setBackgroundColor(Color.GREEN)
                Answer.WRONG -> it.setBackgroundColor(Color.RED)
            }
        }
    }

    override fun disableTouches() {
        buttons.forEach { button ->
            button.isFocusableInTouchMode = false
            button.isClickable = false
            button.setOnClickListener { }
        }
    }

    private fun TextView.setupWithCapitol(capitol: CapitolData) {
        text = capitol.name
        setOnClickListener {
            chosen = it
            onAnswerClick(capitol)
        }
    }
}
