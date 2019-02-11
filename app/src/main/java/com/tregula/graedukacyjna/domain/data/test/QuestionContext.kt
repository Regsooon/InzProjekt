package com.tregula.graedukacyjna.domain.data.test

import android.os.Parcel
import android.os.Parcelable
import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.domain.data.CountryData

data class QuestionContext(val country: CountryData, val continent: ContinentData) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable(CountryData::class.java.classLoader),
            parcel.readParcelable(ContinentData::class.java.classLoader))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(country, flags)
        parcel.writeParcelable(continent, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionContext> {
        override fun createFromParcel(parcel: Parcel): QuestionContext {
            return QuestionContext(parcel)
        }

        override fun newArray(size: Int): Array<QuestionContext?> {
            return arrayOfNulls(size)
        }
    }
}