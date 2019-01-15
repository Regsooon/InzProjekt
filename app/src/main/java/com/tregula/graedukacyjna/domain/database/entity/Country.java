package com.tregula.graedukacyjna.domain.database.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "countries",
        indices = {
                @Index(value = {"name"}, unique = true),
                @Index("continentId")
        })
public class Country {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    public final String name;
    public final Location location;
    public final String capitolName;
    public final Location capitolLocation;
    public final String wiki;
    public final String capitolWiki;
    public Long continentId;

    public Country(String name, Location location, String capitolName, Location capitolLocation, String wiki, String capitolWiki) {
        this.name = name;
        this.location = location;
        this.capitolName = capitolName;
        this.capitolLocation = capitolLocation;
        this.wiki = wiki;
        this.capitolWiki = capitolWiki;
    }
}
