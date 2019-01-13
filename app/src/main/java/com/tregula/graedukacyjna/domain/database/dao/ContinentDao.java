package com.tregula.graedukacyjna.domain.database.dao;

import com.tregula.graedukacyjna.domain.database.entity.ContinentEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Single;

@Dao
public interface ContinentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ContinentEntity> continents);

    @Query("SELECT * from continents")
    Single<List<ContinentEntity>> getContinents();

    @Query("DELETE FROM continents")
    void removeContinents();
}
