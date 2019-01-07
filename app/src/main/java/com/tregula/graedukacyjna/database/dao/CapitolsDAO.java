package com.tregula.graedukacyjna.database.dao;

import com.tregula.graedukacyjna.database.entity.CapitolsDB;
import com.tregula.graedukacyjna.database.entity.CountriesDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CapitolsDAO {

    @Insert
    public void insertCapitols(CapitolsDB... capitols);

    @Query("SELECT * FROM capitols WHERE capitol_name LIKE :name")
    public CapitolsDB loadByName(String name);

    @Query("SELECT captiol_location FROM capitols WHERE captiol_location LIKE :location")
    public CountriesDB loadLocationByName(String location);

    @Query("SELECT * FROM capitols ORDER BY id ASC")
    public CapitolsDB loadAllCapitols();
}
