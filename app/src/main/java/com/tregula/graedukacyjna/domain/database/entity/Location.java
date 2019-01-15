package com.tregula.graedukacyjna.domain.database.entity;

import com.tregula.graedukacyjna.domain.database.entity.converter.LocationConverter;

import androidx.annotation.NonNull;
import androidx.room.TypeConverter;

public class Location {

    public final Double latitude;
    public final Double longitude;

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @NonNull
    @Override
    public String toString() {
        return latitude.toString() +
                "," +
                longitude.toString();
    }

    public static class LocationTypeConverters {

        @TypeConverter
        public static Location fromString(String location) {
            return new LocationConverter().convert(location);
        }

        @TypeConverter
        public static String fromLocation(Location location) {
            return location.toString();
        }
    }
}
