package com.tregula.graedukacyjna.composition.module

import com.tregula.graedukacyjna.domain.concurrent.EducationGameSchedulers
import com.tregula.graedukacyjna.domain.concurrent.GameSchedulers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ConcurrentModule {

    @Provides
    @Singleton
    fun schedulers(): GameSchedulers =
            EducationGameSchedulers()
}
