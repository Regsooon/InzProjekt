package com.tregula.graedukacyjna.services

import android.app.IntentService
import android.content.Intent
import com.tregula.graedukacyjna.concurrent.GameSchedulers
import com.tregula.graedukacyjna.concurrent.action.FetchContinentsData
import com.tregula.graedukacyjna.concurrent.action.PopulateDatabaseWithContinents
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class UpdateApplicationService : IntentService(UpdateApplicationService::class.java.simpleName) {

    @Inject
    lateinit var fetchContinentsData: FetchContinentsData
    @Inject
    lateinit var populateDatabaseWithContinents: PopulateDatabaseWithContinents
    @Inject
    lateinit var gameSchedulers: GameSchedulers

    private val subscribers: CompositeDisposable = CompositeDisposable()

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onHandleIntent(intent: Intent?) {
        val fetchDisposable = fetchContinentsData.execute()
                .subscribeOn(gameSchedulers.io())
                .flatMapCompletable { continentsJson ->
                    populateDatabaseWithContinents.execute(continentsJson)
                }.subscribe()
        subscribers.add(fetchDisposable)
    }

    override fun onDestroy() {
        if (subscribers.isDisposed.not()) {
            subscribers.dispose()
        }
        super.onDestroy()
    }

}