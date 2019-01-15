package com.tregula.graedukacyjna.domain.database;

import android.content.Context;

import com.tregula.graedukacyjna.domain.database.dao.ContinentDao;
import com.tregula.graedukacyjna.domain.database.dao.ContinentsWithCountriesDao;
import com.tregula.graedukacyjna.domain.database.dao.CountryDao;
import com.tregula.graedukacyjna.domain.database.entity.ContinentEntity;
import com.tregula.graedukacyjna.domain.database.entity.CountryEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ContinentEntity.class, CountryEntity.class}, version = 1)
public abstract class CapitolsDatabase extends RoomDatabase {

    public static CapitolsDatabase newInstance(Context context) {
        return Room.databaseBuilder(context, CapitolsDatabase.class, DatabaseConstants.DATABASE_NAME).build();
    }

    public abstract ContinentDao continentDao();

    public abstract CountryDao countriesDao();

    public abstract ContinentsWithCountriesDao continentsWithCountriesDao();
}
