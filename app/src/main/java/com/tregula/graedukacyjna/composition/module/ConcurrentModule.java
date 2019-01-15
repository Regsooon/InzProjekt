package com.tregula.graedukacyjna.composition.module;

import com.tregula.graedukacyjna.domain.concurrent.EducationGameSchedulers;
import com.tregula.graedukacyjna.domain.concurrent.GameSchedulers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ConcurrentModule {

    @Provides
    @Singleton
    public GameSchedulers schedulers() {
        return new EducationGameSchedulers();
    }
}
