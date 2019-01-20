package com.tregula.graedukacyjna.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tregula.graedukacyjna.domain.database.dao.ContinentDao
import com.tregula.graedukacyjna.domain.database.dao.ContinentsWithCountriesDao
import com.tregula.graedukacyjna.domain.database.dao.CountryDao
import com.tregula.graedukacyjna.domain.database.entity.Continent
import com.tregula.graedukacyjna.domain.database.entity.Country
import com.tregula.graedukacyjna.domain.database.entity.Location

@Database(entities = [Continent::class, Country::class], version = 1)
@TypeConverters(Location.LocationTypeConverters::class)
abstract class CapitolsDatabase : RoomDatabase() {

    abstract fun continentDao(): ContinentDao

    abstract fun countriesDao(): CountryDao

    abstract fun continentsWithCountriesDao(): ContinentsWithCountriesDao

    companion object {

        fun newInstance(context: Context): CapitolsDatabase =
                Room.databaseBuilder(context, CapitolsDatabase::class.java, DatabaseConstants.DATABASE_NAME)
                        .build()
    }
}
