package com.tregula.graedukacyjna.database.dao;

import com.tregula.graedukacyjna.database.entity.CountriesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CountriesDAO {

    @Insert
    public void insertCountries(CountriesDB... countries);

    @Query("SELECT * FROM countries WHERE country_name LIKE :name")
    public CountriesDB loadByName(String name);

    @Query("SELECT country_location FROM countries WHERE country_name LIKE :name")
    public CountriesDB loadLocationByName(String name);

    @Query("SELECT * FROM countries ORDER BY id ASC")
    public CountriesDB loadAllCountries();

}
