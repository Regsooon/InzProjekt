package com.tregula.graedukacyjna.domain.data

import android.os.Parcelable
import com.tregula.graedukacyjna.domain.database.entity.Location
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContinentData(val name: String = "",
                         val location: Location = Location.DEFAULT,
                         val wiki: String = "",
                         val countries: List<CountryData> = emptyList()) : Parcelable