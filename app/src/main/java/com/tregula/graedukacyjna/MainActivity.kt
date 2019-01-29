package com.tregula.graedukacyjna

import android.os.Bundle
import com.tregula.graedukacyjna.base.InjectedActivity
import com.tregula.graedukacyjna.navigation.GameNavigation
import com.tregula.graedukacyjna.question.QuestionFragment
import javax.inject.Inject

class MainActivity : InjectedActivity() {

    @Inject
    lateinit var gameNavigation: GameNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gameNavigation.openMainPage()
    }

    override fun onBackPressed() {
        if (!gameNavigation.handleOnBackPress()) {
            super.onBackPressed()
        }
    }
}
