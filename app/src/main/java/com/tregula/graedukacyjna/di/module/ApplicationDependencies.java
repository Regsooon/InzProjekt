package com.tregula.graedukacyjna.di.module;

import android.app.Application;
import android.content.Context;

public class ApplicationDependencies {

    private final Application application;

    public ApplicationDependencies(Application application) {
        this.application = application;
    }

    public Context getContext() {
        return application;
    }
}
