package com.tregula.graedukacyjna.di.module;

import android.app.Application;
import android.content.Context;

import com.tregula.graedukacyjna.domain.database.CapitolsDatabase;
import com.tregula.graedukacyjna.domain.database.DatabaseConstants;

import androidx.room.Room;

public class ApplicationDependencies {

    private final Application application;
    private final CapitolsDatabase capitolsDatabase;

    public ApplicationDependencies(Application application) {
        this.application = application;
        capitolsDatabase = Room.databaseBuilder(application,
                CapitolsDatabase.class,
                DatabaseConstants.DATABASE_NAME).build();
    }

    public Context getContext() {
        return application;
    }

    public CapitolsDatabase getCapitolsDatabase() {
        return capitolsDatabase;
    }
}
