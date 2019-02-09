package com.tregula.graedukacyjna.domain.shared

interface UserPreferences {

    fun isDatabaseCreated(): Boolean

    fun databaseCreationSuccess()
}