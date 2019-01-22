package com.tregula.graedukacyjna.concurrent.action

import com.tregula.graedukacyjna.base.converter.Converter
import com.tregula.graedukacyjna.domain.database.dao.ContinentDao
import com.tregula.graedukacyjna.domain.database.dao.CountryDao
import com.tregula.graedukacyjna.domain.database.entity.Continent
import com.tregula.graedukacyjna.domain.database.entity.Country
import com.tregula.graedukacyjna.domain.remote.data.ContinentJson
import com.tregula.graedukacyjna.domain.remote.data.ContinentsJson
import com.tregula.graedukacyjna.domain.remote.data.CountryJson
import io.reactivex.Completable
import javax.inject.Inject

class PopulateDatabaseWithContinents @Inject constructor(private val continentDao: ContinentDao,
                                                         private val countryDao: CountryDao,
                                                         private val continentConverter: Converter<ContinentJson, Continent>,
                                                         private val countryConverter: Converter<CountryJson, Country>) {

    fun execute(continentsJson: ContinentsJson): Completable {
        return Completable.create { emitter ->
            continentsJson.continents.forEach { continentJson ->
                val continent = continentConverter.convert(continentJson)
                val continentId = continentDao.insert(continent)

                val countries = continentJson.countries.map { countryJson ->
                    val country = countryConverter.convert(countryJson)
                    country.continentId = continentId
                    country
                }
                countryDao.insert(countries)
            }
            emitter.onComplete()
        }
    }
}
