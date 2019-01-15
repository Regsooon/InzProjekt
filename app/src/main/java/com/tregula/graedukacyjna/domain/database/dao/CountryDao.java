package com.tregula.graedukacyjna.domain.database.dao;

import com.tregula.graedukacyjna.domain.database.entity.Country;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Single;

@Dao
public interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Country> countries);

    @Query("SELECT * FROM countries WHERE name LIKE :name")
    Single<Country> loadByName(String name);

    @Query("SELECT * FROM countries ORDER BY name ASC")
    Single<List<Country>> getCountries();
}
