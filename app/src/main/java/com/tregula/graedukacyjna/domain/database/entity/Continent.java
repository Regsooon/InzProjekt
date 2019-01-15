package com.tregula.graedukacyjna.domain.database.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "continents", indices = @Index(value = "name", unique = true))
public class Continent {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    public final String name;
    public final Location location;
    public final String wiki;

    public Continent(String name, Location location, String wiki) {
        this.name = name;
        this.location = location;
        this.wiki = wiki;
    }
}
