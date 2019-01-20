package com.tregula.graedukacyjna.domain.database.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.TypeConverter
import com.tregula.graedukacyjna.domain.database.entity.converter.LocationConverter

data class Location(val latitude: Double, val longitude: Double): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble()
    )

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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {

        val DEFAULT = Location(0.0, 0.0)

        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }
}
