package com.tregula.graedukacyjna.domain.action;

import com.tregula.graedukacyjna.base.converter.Converter;
import com.tregula.graedukacyjna.domain.database.dao.ContinentDao;
import com.tregula.graedukacyjna.domain.database.dao.CountryDao;
import com.tregula.graedukacyjna.domain.database.entity.ContinentEntity;
import com.tregula.graedukacyjna.domain.database.entity.CountryEntity;
import com.tregula.graedukacyjna.domain.remote.ContinentJson;
import com.tregula.graedukacyjna.domain.remote.ContinentsJson;
import com.tregula.graedukacyjna.domain.remote.CountryJson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

public class PopulateDatabaseWithContinents {

    private final ContinentDao continentDao;
    private final CountryDao countryDao;
    private final Converter<ContinentJson, ContinentEntity> continentConverter;
    private final Converter<CountryJson, CountryEntity> countryConverter;

    @Inject
    public PopulateDatabaseWithContinents(ContinentDao continentDao,
                                          CountryDao countryDao,
                                          Converter<ContinentJson, ContinentEntity> continentConverter,
                                          Converter<CountryJson, CountryEntity> countryConverter) {
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
                    ContinentEntity continentEntity = continentConverter.convert(continentJson);
                    long continentId = continentDao.insert(continentEntity);
                    List<CountryEntity> countryEntities = new ArrayList<>();

                    for (CountryJson countryJson : continentJson.countries) {
                        CountryEntity countryEntity = countryConverter.convert(countryJson);
                        countryEntity.continentId = continentId;
                        countryEntities.add(countryEntity);
                    }
                    countryDao.insert(countryEntities);
                }
                emitter.onComplete();
            }
        });
    }
}
