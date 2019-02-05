package com.tregula.graedukacyjna.domain.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.tregula.graedukacyjna.domain.database.entity.ContinentWithCountries
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface ContinentsWithCountriesDao {

    @Transaction
    @Query("SELECT * FROM continents")
    fun getContinents(): Flowable<List<ContinentWithCountries>>

    @Transaction
    @Query("SELECT * FROM continents WHERE name == :name")
    fun getContinentByName(name: String): Single<ContinentWithCountries>
}
