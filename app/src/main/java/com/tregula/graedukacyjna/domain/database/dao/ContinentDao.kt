package com.tregula.graedukacyjna.domain.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tregula.graedukacyjna.domain.database.entity.Continent
import io.reactivex.Single

@Dao
interface ContinentDao {

    @Query("SELECT * from continents")
    fun getContinents(): Single<List<Continent>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(continent: Continent): Long

    @Query("DELETE FROM continents")
    fun removeContinents()
}
