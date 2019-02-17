package com.tregula.graedukacyjna.domain.data

import android.os.Parcelable
import com.tregula.graedukacyjna.domain.database.entity.Location
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CapitolData(
        val name: String = "",
        val location: Location = Location.DEFAULT,
        val wiki: String = "") : Parcelable