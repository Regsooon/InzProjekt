package com.tregula.graedukacyjna.view.mode

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout

import com.tregula.graedukacyjna.R

class ModeChooseView : LinearLayout {

    private lateinit var learnMode: Button
    private lateinit var testMode: Button

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
        inflate(context, R.layout.mode_choose_view, this)
        learnMode = findViewById(R.id.learn_mode_button)
        testMode = findViewById(R.id.test_mode_button)
    }
}
