package com.tregula.graedukacyjna.composition.module;

import android.content.Context;

import com.tregula.graedukacyjna.domain.database.CapitolsDatabase;
import com.tregula.graedukacyjna.domain.database.dao.ContinentDao;
import com.tregula.graedukacyjna.domain.database.dao.ContinentsWithCountriesDao;
import com.tregula.graedukacyjna.domain.database.dao.CountryDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Singleton
    @Provides
    public CapitolsDatabase provideCapitolsDatabase(Context context) {
        return CapitolsDatabase.newInstance(context);
    }

    @Provides
    public ContinentDao provideContinentDao(CapitolsDatabase database) {
        return database.continentDao();
    }

    @Provides
    public CountryDao provideCountriesDao(CapitolsDatabase database) {
        return database.countriesDao();
    }

    @Provides
    public ContinentsWithCountriesDao provideContinentWithCountriesDao(CapitolsDatabase database) {
        return database.continentsWithCountriesDao();
    }
}
