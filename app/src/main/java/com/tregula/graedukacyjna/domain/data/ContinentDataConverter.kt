package com.tregula.graedukacyjna.domain.data

import com.tregula.graedukacyjna.base.converter.Converter
import com.tregula.graedukacyjna.domain.database.entity.ContinentWithCountries
import com.tregula.graedukacyjna.domain.database.entity.Country

class ContinentDataConverter : Converter<ContinentWithCountries, ContinentData> {

    override fun convert(input: ContinentWithCountries): ContinentData =
        input.continent?.let { continentEntity ->
            ContinentData(
                continentEntity.name,
                continentEntity.location,
                continentEntity.wiki,
                input.countries?.map(::transformCountryData)
                    .orEmpty()
            )
        } ?: ContinentData()

    private fun transformCountryData(countryEntity: Country) =
        CountryData(
            countryEntity.name,
            countryEntity.location,
            countryEntity.wiki,
            CapitolData(
                countryEntity.capitolName,
                countryEntity.capitolLocation,
                countryEntity.capitolWiki
            )
        )
}