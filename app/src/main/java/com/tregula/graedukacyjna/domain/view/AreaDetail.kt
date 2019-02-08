package com.tregula.graedukacyjna.domain.view

import com.tregula.graedukacyjna.domain.database.entity.Location

data class AreaDetail(val countryName: String,
                      val capitolName: String,
                      val countryUrl: String,
                      val capitolUrl: String,
                      val capitolLocation: Location)