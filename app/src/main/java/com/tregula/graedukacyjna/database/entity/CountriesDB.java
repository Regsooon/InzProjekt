package com.tregula.graedukacyjna.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "countries")
public class CountriesDB {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "country_name")
    public String countryName;

    @ColumnInfo(name = "country_location")
    public String countryLocation;

    @ColumnInfo(name = "country_capitol")
    public String countryCapitol;

    @ColumnInfo(name = "country_wiki")
    public String countyWiki;
}
