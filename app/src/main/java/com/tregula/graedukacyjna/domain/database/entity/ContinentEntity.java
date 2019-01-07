package com.tregula.graedukacyjna.domain.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "continents")
public class ContinentEntity {

    @PrimaryKey(autoGenerate = true)
    public final int id;
    public final String continentName;
    public final String continentLocation;
    public final String continentWiki;

    public ContinentEntity(int id, String continentName, String continentLocation, String continentWiki) {
        this.id = id;
        this.continentName = continentName;
        this.continentLocation = continentLocation;
        this.continentWiki = continentWiki;
    }
}
