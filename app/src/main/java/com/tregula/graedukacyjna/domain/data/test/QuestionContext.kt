package com.tregula.graedukacyjna.domain.data.test

import android.os.Parcelable
import com.tregula.graedukacyjna.domain.data.CountryData
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuestionContext(val question: CountryData, val answerPool: List<CountryData>) : Parcelable