package com.tregula.graedukacyjna.domain.remote.data

data class CountryJson(val country_name: String,
                       val country_longitude: String,
                       val country_latitude: String,
                       val country_wiki: String,
                       val capitol: CapitolJson)
