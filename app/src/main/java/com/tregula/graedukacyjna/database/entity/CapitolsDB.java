package com.tregula.graedukacyjna.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "capitols")
public class CapitolsDB {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "capitol_name")
    public String capitolName;

    @ColumnInfo(name = "captiol_location")
    public String capitolLocation;

}


