package com.tregula.graedukacyjna.domain.data

import android.os.Parcel
import android.os.Parcelable
import com.tregula.graedukacyjna.domain.database.entity.Location

data class CountryData(val name: String = "",
                       val location: Location = Location.DEFAULT,
                       val wiki: String = "",
                       val capitol: CapitolData = CapitolData()) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readParcelable(Location::class.java.classLoader),
            parcel.readString(),
            parcel.readParcelable(CapitolData::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeParcelable(location, flags)
        parcel.writeString(wiki)
        parcel.writeParcelable(capitol, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CountryData> {
        override fun createFromParcel(parcel: Parcel): CountryData {
            return CountryData(parcel)
        }

        override fun newArray(size: Int): Array<CountryData?> {
            return arrayOfNulls(size)
        }
    }
}