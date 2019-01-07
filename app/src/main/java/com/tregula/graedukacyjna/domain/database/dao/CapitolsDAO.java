package com.tregula.graedukacyjna.domain.database.dao;

import com.tregula.graedukacyjna.domain.database.entity.CapitolEntity;
import com.tregula.graedukacyjna.domain.database.entity.CountryEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface CapitolsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCapitols(List<CapitolEntity> capitols);

    @Query("SELECT * FROM capitols WHERE capitolName LIKE :name")
    Single<CapitolEntity> loadByName(String name);

    @Query("SELECT * FROM capitols WHERE capitolLocation LIKE :location")
    Single<CapitolEntity> getCapitol(String location);

    @Query("SELECT * FROM capitols ORDER BY id ASC")
    Single<List<CapitolEntity>> getCapitols();
}
