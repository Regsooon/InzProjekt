package com.tregula.graedukacyjna.domain.database.dao;

import com.tregula.graedukacyjna.domain.database.entity.Continent;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Single;

@Dao
public interface ContinentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Continent continent);

    @Query("SELECT * from continents")
    Single<List<Continent>> getContinents();

    @Query("DELETE FROM continents")
    void removeContinents();
}
