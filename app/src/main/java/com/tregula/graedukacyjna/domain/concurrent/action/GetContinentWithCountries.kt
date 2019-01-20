package com.tregula.graedukacyjna.domain.concurrent.action

import com.tregula.graedukacyjna.domain.database.dao.ContinentsWithCountriesDao
import com.tregula.graedukacyjna.domain.database.entity.ContinentWithCountries
import io.reactivex.Single
import javax.inject.Inject

class GetContinentWithCountries @Inject constructor(private val continentsWithCountriesDao: ContinentsWithCountriesDao) {

    fun execute(): Single<List<ContinentWithCountries>> =
        continentsWithCountriesDao.getContinents()

}