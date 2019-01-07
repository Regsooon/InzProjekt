package com.tregula.graedukacyjna.domain.database.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "countries",
        foreignKeys = @ForeignKey(entity = ContinentEntity.class,
                parentColumns = "id",
                childColumns = "continentId",
                onDelete = ForeignKey.CASCADE))
public class CountryEntity {

    @PrimaryKey(autoGenerate = true)
    public final int id;
    public final String countryName;
    public final String countryLocation;
    public final String countryCapitol;
    public final String countyWiki;
    public final int continentId;

    public CountryEntity(int id, String countryName, String countryLocation, String countryCapitol, String countyWiki, int continentId) {
        this.id = id;
        this.countryName = countryName;
        this.countryLocation = countryLocation;
        this.countryCapitol = countryCapitol;
        this.countyWiki = countyWiki;
        this.continentId = continentId;
    }
}
