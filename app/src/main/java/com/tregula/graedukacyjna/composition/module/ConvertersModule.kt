package com.tregula.graedukacyjna.composition.module

import com.tregula.graedukacyjna.base.converter.Converter
import com.tregula.graedukacyjna.domain.database.entity.Continent
import com.tregula.graedukacyjna.domain.database.entity.Country
import com.tregula.graedukacyjna.domain.database.entity.Location
import com.tregula.graedukacyjna.domain.database.entity.converter.ContinentConverter
import com.tregula.graedukacyjna.domain.database.entity.converter.CountryConverter
import com.tregula.graedukacyjna.domain.database.entity.converter.LocationConverter
import com.tregula.graedukacyjna.domain.remote.data.ContinentJson
import com.tregula.graedukacyjna.domain.remote.data.CountryJson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ConvertersModule {

    @Provides
    @Singleton
    fun provideLocationConverter(): Converter<String, Location> =
            LocationConverter()

    @Provides
    @Singleton
    fun provideContinentConverter(locationConverter: Converter<String, Location>): Converter<ContinentJson, Continent> =
            ContinentConverter(locationConverter)

    @Provides
    @Singleton
    fun provideCountryConverter(locationConverter: Converter<String, Location>): Converter<CountryJson, Country> =
            CountryConverter(locationConverter)
}
