package com.tregula.graedukacyjna.domain.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "countries", indices = [Index(value = ["name"], unique = true), Index("continentId")])
class Country(val name: String,
              val location: Location,
              val capitolName: String,
              val capitolLocation: Location,
              val wiki: String,
              val capitolWiki: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
    var continentId: Long? = null
}
