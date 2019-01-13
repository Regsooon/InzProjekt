package com.tregula.graedukacyjna.domain.database.entity;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

public class ContinentWithCountries {
    @Embedded
    public ContinentEntity continent;

    @Relation(parentColumn = "id",
            entityColumn = "continentId")
    public List<CountryEntity> countries;
}
