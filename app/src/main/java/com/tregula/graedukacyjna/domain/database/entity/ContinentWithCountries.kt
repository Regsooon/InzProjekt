package com.tregula.graedukacyjna.domain.database.entity

import androidx.room.Embedded
import androidx.room.Relation

class ContinentWithCountries {
    @Embedded
    var continent: Continent? = null

    @Relation(parentColumn = "id", entityColumn = "continentId")
    var countries: List<Country>? = null
}
