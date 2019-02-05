package com.tregula.graedukacyjna.view.mode

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.tregula.graedukacyjna.R

class ModeChooseView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var onLearnClick: () -> Unit = {}
    var onTestClick: () -> Unit = {}

    init {
        View.inflate(context, R.layout.mode_choose_view, this)
        val learnMode: Button = findViewById(R.id.learn_mode_button)
        val testMode: Button = findViewById(R.id.test_mode_button)

        learnMode.setOnClickListener {
            onLearnClick()
        }
        testMode.setOnClickListener {
            onTestClick()
        }
    }
}
