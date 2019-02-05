package com.tregula.graedukacyjna.concurrent.action

import com.tregula.graedukacyjna.concurrent.GameSchedulers
import io.reactivex.Completable
import javax.inject.Inject

class CreateContinentsDatabase @Inject constructor(private val fetchContinentsData: FetchContinentsData,
                                                   private val populateDatabase: PopulateDatabaseWithContinents,
                                                   private val gameSchedulers: GameSchedulers) {

    fun execute(): Completable =
            fetchContinentsData.execute()
                    .subscribeOn(gameSchedulers.io())
                    .observeOn(gameSchedulers.io())
                    .flatMapCompletable { populateDatabase.execute(it) }
}