package com.tregula.graedukacyjna;

import android.app.Application;

import com.tregula.graedukacyjna.di.DependencyGraph;
import com.tregula.graedukacyjna.di.ApplicationComponentBuilder;

public class GraEdukacyjna extends Application {

    private DependencyGraph dependencyGraph;

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
