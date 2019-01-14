package com.tregula.graedukacyjna.domain.database.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "countries",
        indices = {
                @Index(value = {"name"}, unique = true),
                @Index("continentId")
        })
public class CountryEntity {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    public final String name;
    public final String location;
    public final String capitolName;
    public final String capitolLocation;
    public final String wiki;
    public final Long continentId;

    public CountryEntity(String name, String location, String capitolName, String capitolLocation, String wiki, Long continentId) {
        this.name = name;
        this.location = location;
        this.capitolName = capitolName;
        this.capitolLocation = capitolLocation;
        this.wiki = wiki;
        this.continentId = continentId;
    }
}
