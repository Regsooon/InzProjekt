package com.tregula.graedukacyjna.domain.repository

import com.tregula.graedukacyjna.concurrent.action.FetchContinentsData
import com.tregula.graedukacyjna.concurrent.action.GetContinentsData
import com.tregula.graedukacyjna.concurrent.action.PopulateDatabaseWithContinents
import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.domain.shared.UserPreferences
import io.reactivex.Single
import javax.inject.Inject

class GameContinentsRepository @Inject constructor(private val fetchContinentsData: FetchContinentsData,
                                                   private val getContinentsData: GetContinentsData,
                                                   private val populateDatabaseWithContinents: PopulateDatabaseWithContinents,
                                                   private val userPreferences: UserPreferences) : ContinentsRepository {

    override fun getContinentsData(): Single<List<ContinentData>> =
            if (userPreferences.isDatabaseCreated()) fromLocalDatabase() else
                fetchFromRemoteSource()

    private fun fromLocalDatabase(): Single<List<ContinentData>> =
            getContinentsData.execute()

    private fun fetchFromRemoteSource(): Single<List<ContinentData>> =
            fetchContinentsData.execute()
                    .flatMapCompletable { continentsJson ->
                        populateDatabaseWithContinents.execute(continentsJson)
                    }
                    .andThen { emitter ->
                        userPreferences.databaseCreationSuccess()
                        emitter.onComplete()
                    }
                    .andThen(getContinentsData.execute())
}