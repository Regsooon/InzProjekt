package com.tregula.graedukacyjna.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "continent")
public class ContinentDB {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "continen_name")
    public String continentName;

    @ColumnInfo(name = "continent_location")
    public String continentLocation;

    //@ColumnInfo(name = "countries_list")
    // public List<CountriesDB> countriesList;

    @ColumnInfo(name = "continent_wiki")
    public String continentWiki;
}
