package com.tregula.graedukacyjna.domain.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tregula.graedukacyjna.domain.database.entity.Country
import io.reactivex.Single

@Dao
interface CountryDao {

    @Query("SELECT * FROM countries ORDER BY name ASC")
    fun getCountries(): Single<List<Country>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(countries: List<Country>)

    @Query("SELECT * FROM countries WHERE name LIKE :name")
    fun loadByName(name: String): Single<Country>
}
