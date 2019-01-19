package com.tregula.graedukacyjna.composition.module

import android.content.Context
import com.tregula.graedukacyjna.domain.database.CapitolsDatabase
import com.tregula.graedukacyjna.domain.database.dao.ContinentDao
import com.tregula.graedukacyjna.domain.database.dao.ContinentsWithCountriesDao
import com.tregula.graedukacyjna.domain.database.dao.CountryDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideCapitolsDatabase(context: Context): CapitolsDatabase =
            CapitolsDatabase.newInstance(context)


    @Provides
    fun provideContinentDao(database: CapitolsDatabase): ContinentDao =
            database.continentDao()

    @Provides
    fun provideCountriesDao(database: CapitolsDatabase): CountryDao =
            database.countriesDao()

    @Provides
    fun provideContinentWithCountriesDao(database: CapitolsDatabase): ContinentsWithCountriesDao =
            database.continentsWithCountriesDao()
}
