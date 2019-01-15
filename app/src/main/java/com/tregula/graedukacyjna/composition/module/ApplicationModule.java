package com.tregula.graedukacyjna.composition.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    public Context providesContext(Application application) {
        return application;
    }
}
