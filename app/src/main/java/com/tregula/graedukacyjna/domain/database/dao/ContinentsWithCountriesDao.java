package com.tregula.graedukacyjna.domain.database.dao;

import com.tregula.graedukacyjna.domain.database.entity.ContinentWithCountries;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;
import io.reactivex.Single;

@Dao
public interface ContinentsWithCountriesDao {

    @Transaction
    @Query("SELECT * FROM continents")
    Single<List<ContinentWithCountries>> getContinents();

    @Transaction
    @Query("SELECT * FROM continents WHERE name == :name")
    Single<ContinentWithCountries> getContinentByName(String name);

}
