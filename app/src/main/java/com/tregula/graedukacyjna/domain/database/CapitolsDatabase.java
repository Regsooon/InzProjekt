package com.tregula.graedukacyjna.domain.database;

import android.content.Context;

import com.tregula.graedukacyjna.domain.database.dao.ContinentDao;
import com.tregula.graedukacyjna.domain.database.dao.ContinentsWithCountriesDao;
import com.tregula.graedukacyjna.domain.database.dao.CountryDao;
import com.tregula.graedukacyjna.domain.database.entity.Continent;
import com.tregula.graedukacyjna.domain.database.entity.Country;
import com.tregula.graedukacyjna.domain.database.entity.Location;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Continent.class, Country.class}, version = 1)
@TypeConverters({Location.LocationTypeConverters.class})
public abstract class CapitolsDatabase extends RoomDatabase {

    public static CapitolsDatabase newInstance(Context context) {
        return Room.databaseBuilder(context, CapitolsDatabase.class, DatabaseConstants.DATABASE_NAME).build();
    }

    public abstract ContinentDao continentDao();

    public abstract CountryDao countriesDao();

    public abstract ContinentsWithCountriesDao continentsWithCountriesDao();
}
