package com.tregula.graedukacyjna.domain.repository

import com.tregula.graedukacyjna.concurrent.action.FetchContinentsData
import com.tregula.graedukacyjna.concurrent.action.GetContinentsData
import com.tregula.graedukacyjna.concurrent.action.PopulateDatabaseWithContinents
import com.tregula.graedukacyjna.domain.data.ContinentData
import io.reactivex.Single

class GameContinentsRepository constructor(private val fetchContinentsData: FetchContinentsData,
                                           private val getContinentsData: GetContinentsData,
                                           private val populateDatabaseWithContinents: PopulateDatabaseWithContinents) : ContinentsRepository {
    override fun getContinentsData(): Single<ContinentData> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}