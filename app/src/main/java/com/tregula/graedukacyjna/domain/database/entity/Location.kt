package com.tregula.graedukacyjna.domain.database.entity

import com.tregula.graedukacyjna.domain.database.entity.converter.LocationConverter
import androidx.room.TypeConverter

data class Location(val latitude: Double, val longitude: Double) {

    override fun toString(): String {
        return latitude.toString() +
                "," +
                longitude.toString()
    }

    object LocationTypeConverters {

        @TypeConverter
        @JvmStatic
        fun fromString(location: String): Location {
            return LocationConverter().convert(location)
        }

        @TypeConverter
        @JvmStatic
        fun fromLocation(location: Location): String {
            return location.toString()
        }
    }
}
