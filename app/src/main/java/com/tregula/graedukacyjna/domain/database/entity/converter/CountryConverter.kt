package com.tregula.graedukacyjna.domain.database.entity.converter

import com.tregula.graedukacyjna.base.converter.Converter
import com.tregula.graedukacyjna.domain.database.entity.Country
import com.tregula.graedukacyjna.domain.database.entity.Location
import com.tregula.graedukacyjna.domain.remote.data.CountryJson

class CountryConverter(private val locationConverter: Converter<String, Location>) : Converter<CountryJson, Country> {

    override fun convert(input: CountryJson): Country {
        val countryLocation = locationConverter.convert("${input.country_latitude},${input.country_longitude}")
        val capitolJson = input.capitol
        val capitolLocation = locationConverter.convert("${capitolJson.capitol_latitude},${capitolJson.capitol_longitude}")

        return Country(input.country_name,
                countryLocation,
                capitolJson.capitol_name,
                capitolLocation,
                input.country_wiki,
                capitolJson.capitol_wiki)
    }
}
