package com.tregula.graedukacyjna.domain.repository

import com.tregula.graedukacyjna.domain.data.ContinentData
import io.reactivex.Single

interface ContinentsRepository {

    fun getContinentsData(): Single<ContinentData>
}