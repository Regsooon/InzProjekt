package com.tregula.graedukacyjna.domain.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "continents", indices = [Index(value = ["name"], unique = true)])
class Continent(val name: String,
                val location: Location,
                val wiki: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}
