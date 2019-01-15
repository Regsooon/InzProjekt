package com.tregula.graedukacyjna.composition.module;

import android.app.Application;
import android.content.Context;

import com.google.firebase.storage.FirebaseStorage;
import com.squareup.moshi.Moshi;

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

    @Provides
    @Singleton
    public FirebaseStorage provideFirebaseStorage() {
        return FirebaseStorage.getInstance();
    }

    @Provides
    public Moshi provideMoshi() {
        return new Moshi.Builder().build();
    }
}
