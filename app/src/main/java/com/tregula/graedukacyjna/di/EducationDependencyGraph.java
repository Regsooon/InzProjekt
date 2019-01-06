package com.tregula.graedukacyjna.di;

import android.app.Application;
import android.content.Context;

import com.tregula.graedukacyjna.di.module.ApplicationDependencies;
import com.tregula.graedukacyjna.di.module.ConcurrentDependencies;
import com.tregula.graedukacyjna.domain.concurrent.GameSchedulers;

public class EducationDependencyGraph implements DependencyGraph {

    private final ConcurrentDependencies concurrentDependencies;
    private final ApplicationDependencies applicationDependencies;

    public EducationDependencyGraph(Application application) {
        concurrentDependencies = new ConcurrentDependencies();
        applicationDependencies = new ApplicationDependencies(application);
    }

    @Override
    public Context provideContext() {
        return applicationDependencies.getContext();
    }

    @Override
    public GameSchedulers provideGameSchedulers() {
        return concurrentDependencies.schedulers();
    }
}
