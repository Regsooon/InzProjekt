package com.tregula.graedukacyjna.composition.module

import com.tregula.graedukacyjna.domain.repository.ContinentsRepository
import com.tregula.graedukacyjna.domain.repository.GameContinentsRepository
import com.tregula.graedukacyjna.domain.shared.SharedUserPreferences
import com.tregula.graedukacyjna.domain.shared.UserPreferences
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserPreferences(sharedUserPreferences: SharedUserPreferences): UserPreferences

    @Binds
    @Singleton
    abstract fun bindsContinentsRepository(gameContinentsRepository: GameContinentsRepository): ContinentsRepository
}