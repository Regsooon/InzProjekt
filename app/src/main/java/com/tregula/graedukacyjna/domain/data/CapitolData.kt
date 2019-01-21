package com.tregula.graedukacyjna.domain.data

import android.os.Parcel
import android.os.Parcelable
import com.tregula.graedukacyjna.domain.database.entity.Location

data class CapitolData(val name: String = "",
                       val location: Location = Location.DEFAULT,
                       val wiki: String = "") : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readParcelable(Location::class.java.classLoader),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeParcelable(location, flags)
        parcel.writeString(wiki)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CapitolData> {
        override fun createFromParcel(parcel: Parcel): CapitolData {
            return CapitolData(parcel)
        }

        override fun newArray(size: Int): Array<CapitolData?> {
            return arrayOfNulls(size)
        }
    }
}