package com.tregula.graedukacyjna.view.mode

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

import com.tregula.graedukacyjna.R

class ModeChooseView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    val learnMode: Button
    val testMode: Button

    init {
        View.inflate(context, R.layout.mode_choose_view, this)
        learnMode = findViewById(R.id.learn_mode_button)
        testMode = findViewById(R.id.test_mode_button)
    }
}
