package com.tregula.graedukacyjna.domain.database.entity.converter

import com.tregula.graedukacyjna.base.converter.Converter
import com.tregula.graedukacyjna.domain.database.entity.Location
import com.tregula.graedukacyjna.utils.DoubleParser

class LocationConverter : Converter<String, Location> {

    private val parser = DoubleParser()

    override fun convert(input: String): Location {
        val locations = input.split(",")
        return if (locations.size == 2) {
            Location(parser.parse(locations[0]), parser.parse(locations[1]))
        } else Location(0.0, 0.0)
    }

}