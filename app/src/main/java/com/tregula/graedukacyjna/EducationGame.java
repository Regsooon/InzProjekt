package com.tregula.graedukacyjna;

import android.app.Application;
import android.content.Context;

import com.tregula.graedukacyjna.di.ApplicationComponentBuilder;
import com.tregula.graedukacyjna.di.DependencyGraph;

public class EducationGame extends Application {

    private DependencyGraph dependencyGraph;

    public static EducationGame getInstance(Context context) {
        return (EducationGame) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dependencyGraph = new ApplicationComponentBuilder()
                .application(this)
                .build();
    }

    public DependencyGraph dependencyGraph() {
        return dependencyGraph;
    }
}
