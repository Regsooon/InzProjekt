package com.tregula.graedukacyjna.domain.remote.data

data class ContinentJson(val continent_name: String,
                         val continent_latitude: String,
                         val continent_longitude: String,
                         val continent_wiki: String,
                         val countries: List<CountryJson>)
