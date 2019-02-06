package com.tregula.graedukacyjna.view.question

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import com.tregula.graedukacyjna.R

class QuestionView : LinearLayout {

    private lateinit var firstAnswer: Button
    private lateinit var secondAnswer: Button
    private lateinit var thirdAnswer: Button
    private lateinit var forthAnswer: Button

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        inflate(context, R.layout.question_view, this)
        firstAnswer = findViewById(R.id.first_answear)
        secondAnswer = findViewById(R.id.second_answear)
        thirdAnswer = findViewById(R.id.third_answear)
        forthAnswer = findViewById(R.id.forth_answear)
    }
}
