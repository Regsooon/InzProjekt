package com.tregula.graedukacyjna.domain.data

import android.os.Parcel
import android.os.Parcelable
import com.tregula.graedukacyjna.domain.database.entity.Location

data class ContinentData(
    val name: String = "",
    val location: Location = Location.DEFAULT,
    val wiki: String = "",
    val countries: List<CountryData>
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(Location::class.java.classLoader),
        parcel.readString(),
        parcel.createTypedArrayList(CountryData)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeParcelable(location, flags)
        parcel.writeString(wiki)
        parcel.writeTypedList(countries)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContinentData> {
        override fun createFromParcel(parcel: Parcel): ContinentData {
            return ContinentData(parcel)
        }

        override fun newArray(size: Int): Array<ContinentData?> {
            return arrayOfNulls(size)
        }
    }
}