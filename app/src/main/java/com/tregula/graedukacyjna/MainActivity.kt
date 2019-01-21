package com.tregula.graedukacyjna

import android.content.Intent
import android.os.Bundle
import com.tregula.graedukacyjna.base.InjectedActivity
import com.tregula.graedukacyjna.question.QuestionFragment
import com.tregula.graedukacyjna.services.UpdateApplicationService

class MainActivity : InjectedActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, QuestionFragment())
                .commitAllowingStateLoss()

        startDatabaseUpdate()
    }

    private fun startDatabaseUpdate() {
        startService(Intent(this, UpdateApplicationService::class.java))
    }
}
