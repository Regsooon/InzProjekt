package com.tregula.graedukacyjna

import android.os.Bundle
import android.widget.Toast
import com.tregula.graedukacyjna.base.InjectedActivity
import com.tregula.graedukacyjna.concurrent.action.CreateContinentsDatabase
import com.tregula.graedukacyjna.navigation.GameNavigation
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : InjectedActivity() {

    private val subscribers: CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var createContinentsDatabase: CreateContinentsDatabase

    @Inject
    lateinit var gameNavigation: GameNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDatabase()
        setContentView(R.layout.activity_main)
        gameNavigation.openMainPage()
    }

    override fun onBackPressed() {
        if (!gameNavigation.handleOnBackPress()) {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (subscribers.isDisposed.not()) {
            subscribers.dispose()
        }
    }

    private fun createDatabase() {
        val fetchDisposable = createContinentsDatabase.execute()
                .subscribe {
                    Toast.makeText(this, R.string.loading_complete, Toast.LENGTH_LONG).show()
                }
        subscribers.add(fetchDisposable)
    }
}
