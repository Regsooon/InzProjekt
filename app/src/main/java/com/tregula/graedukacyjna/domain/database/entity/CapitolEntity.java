package com.tregula.graedukacyjna.domain.database.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "capitols",
        foreignKeys = @ForeignKey(entity = CountryEntity.class,
                parentColumns = "id",
                childColumns = "countryId",
                onDelete = ForeignKey.CASCADE))
public class CapitolEntity {

    @PrimaryKey(autoGenerate = true)
    public final int id;
    public final String capitolName;
    public final String capitolLocation;
    public final int countryId;

    public CapitolEntity(int id, String capitolName, String capitolLocation, int countryId) {
        this.id = id;
        this.capitolName = capitolName;
        this.capitolLocation = capitolLocation;
        this.countryId = countryId;
    }
}


