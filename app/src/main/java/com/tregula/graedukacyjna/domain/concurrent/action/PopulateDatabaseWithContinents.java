package com.tregula.graedukacyjna.domain.concurrent.action;

import com.tregula.graedukacyjna.base.converter.Converter;
import com.tregula.graedukacyjna.domain.database.dao.ContinentDao;
import com.tregula.graedukacyjna.domain.database.dao.CountryDao;
import com.tregula.graedukacyjna.domain.database.entity.Continent;
import com.tregula.graedukacyjna.domain.database.entity.Country;
import com.tregula.graedukacyjna.domain.remote.data.ContinentJson;
import com.tregula.graedukacyjna.domain.remote.data.ContinentsJson;
import com.tregula.graedukacyjna.domain.remote.data.CountryJson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

public class PopulateDatabaseWithContinents {

    private final ContinentDao continentDao;
    private final CountryDao countryDao;
    private final Converter<ContinentJson, Continent> continentConverter;
    private final Converter<CountryJson, Country> countryConverter;

    @Inject
    public PopulateDatabaseWithContinents(ContinentDao continentDao,
                                          CountryDao countryDao,
                                          Converter<ContinentJson, Continent> continentConverter,
                                          Converter<CountryJson, Country> countryConverter) {
        this.continentDao = continentDao;
        this.countryDao = countryDao;
        this.continentConverter = continentConverter;
        this.countryConverter = countryConverter;
    }

    public Completable execute(final ContinentsJson continentsJson) {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) {
                for (ContinentJson continentJson : continentsJson.continents) {
                    Continent continent = continentConverter.convert(continentJson);
                    long continentId = continentDao.insert(continent);
                    List<Country> countryEntities = new ArrayList<>();

                    for (CountryJson countryJson : continentJson.countries) {
                        Country country = countryConverter.convert(countryJson);
                        country.continentId = continentId;
                        countryEntities.add(country);
                    }
                    countryDao.insert(countryEntities);
                }
                emitter.onComplete();
            }
        });
    }
}
