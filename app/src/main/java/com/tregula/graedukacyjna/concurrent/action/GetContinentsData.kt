package com.tregula.graedukacyjna.concurrent.action

import com.tregula.graedukacyjna.base.converter.Converter
import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.domain.database.dao.ContinentsWithCountriesDao
import com.tregula.graedukacyjna.domain.database.entity.ContinentWithCountries
import io.reactivex.Single
import javax.inject.Inject

class GetContinentsData @Inject constructor(private val converter: Converter<ContinentWithCountries, ContinentData>,
                                            private val continentWithCountriesDao: ContinentsWithCountriesDao) {

    fun execute(): Single<List<ContinentData>> =
            continentWithCountriesDao.getContinents().map { list ->
                list.map { entity -> converter.convert(entity) }
            }
}