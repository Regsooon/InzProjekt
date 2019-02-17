package com.tregula.graedukacyjna.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.tregula.graedukacyjna.R

class ScoreView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    var onNavigateBack: () -> Unit = {}

    private val score: TextView

    init {
        View.inflate(context, R.layout.score_view, this)
        score = findViewById(R.id.score_label)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            onNavigateBack()
        }
    }

    fun setScore(scoreResult: Int) {
        score.text = context.getString(R.string.score, scoreResult.toString())
    }
}
