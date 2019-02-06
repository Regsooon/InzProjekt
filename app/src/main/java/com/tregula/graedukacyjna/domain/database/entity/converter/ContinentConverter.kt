package com.tregula.graedukacyjna.domain.database.entity.converter

import com.tregula.graedukacyjna.base.converter.Converter
import com.tregula.graedukacyjna.domain.database.entity.Continent
import com.tregula.graedukacyjna.domain.database.entity.Location
import com.tregula.graedukacyjna.domain.remote.ContinentJson

class ContinentConverter(private val locationConverter: Converter<String, Location>) : Converter<ContinentJson, Continent> {

    override fun convert(input: ContinentJson): Continent {
        val location = locationConverter.convert("${input.continent_latitude},${input.continent_longitude}")

        return Continent(input.continent_name,
                location,
                input.continent_wiki)
    }
}
