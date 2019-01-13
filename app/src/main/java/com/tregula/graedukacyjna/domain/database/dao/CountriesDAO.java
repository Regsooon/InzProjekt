package com.tregula.graedukacyjna.domain.database.dao;

import com.tregula.graedukacyjna.domain.database.entity.CountryEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface CountriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<CountryEntity> countries);

    @Query("SELECT * FROM countries WHERE name LIKE :name")
    Single<CountryEntity> loadByName(String name);

    @Query("SELECT * FROM countries ORDER BY name ASC")
    Single<List<CountryEntity>> getCountries();
}
