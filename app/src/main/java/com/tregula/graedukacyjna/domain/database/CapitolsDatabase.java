package com.tregula.graedukacyjna.domain.database;

import com.tregula.graedukacyjna.domain.database.dao.ContinentDao;
import com.tregula.graedukacyjna.domain.database.dao.ContinentsWithCountriesDao;
import com.tregula.graedukacyjna.domain.database.dao.CountriesDao;
import com.tregula.graedukacyjna.domain.database.entity.ContinentEntity;
import com.tregula.graedukacyjna.domain.database.entity.CountryEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ContinentEntity.class, CountryEntity.class}, version = 1)
public abstract class CapitolsDatabase extends RoomDatabase {

    public abstract ContinentDao continentDao();

    public abstract CountriesDao countriesDao();

    public abstract ContinentsWithCountriesDao continentsWithCountriesDao();
}
