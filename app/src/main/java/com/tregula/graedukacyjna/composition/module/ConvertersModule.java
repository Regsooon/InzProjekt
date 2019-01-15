package com.tregula.graedukacyjna.composition.module;

import com.tregula.graedukacyjna.base.converter.Converter;
import com.tregula.graedukacyjna.domain.database.entity.Continent;
import com.tregula.graedukacyjna.domain.database.entity.Country;
import com.tregula.graedukacyjna.domain.database.entity.Location;
import com.tregula.graedukacyjna.domain.database.entity.converter.ContinentConverter;
import com.tregula.graedukacyjna.domain.database.entity.converter.CountryConverter;
import com.tregula.graedukacyjna.domain.database.entity.converter.LocationConverter;
import com.tregula.graedukacyjna.domain.remote.ContinentJson;
import com.tregula.graedukacyjna.domain.remote.CountryJson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ConvertersModule {

    @Provides
    @Singleton
    public Converter<String, Location> provideLocationConverter(){
        return new LocationConverter();
    }

    @Provides
    @Singleton
    public Converter<ContinentJson, Continent> provideContinentConverter(Converter<String, Location> locationConverter){
        return new ContinentConverter(locationConverter);
    }

    @Provides
    @Singleton
    public Converter<CountryJson, Country> provideCountryConverter(Converter<String, Location> locationConverter){
        return new CountryConverter(locationConverter);
    }
}
