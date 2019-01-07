package com.tregula.graedukacyjna.database.entity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CapitolsDB.class, ContinentDB.class, CountriesDB.class}, version = 1)
public abstract class CapitolsDatabase extends RoomDatabase {

}
