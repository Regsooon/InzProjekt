package com.tregula.graedukacyjna.domain.shared

import android.content.SharedPreferences

class SharedUserPreferences(private val sharedPreferences: SharedPreferences) : UserPreferences {

    companion object {
        private const val DATABASE_KEY = "game_database_key"
    }

    override fun isDatabaseCreated(): Boolean = sharedPreferences.getBoolean(DATABASE_KEY, false)

    override fun databaseCreationSuccess() =
            sharedPreferences.edit()
                    .putBoolean(DATABASE_KEY, true)
                    .apply()
}