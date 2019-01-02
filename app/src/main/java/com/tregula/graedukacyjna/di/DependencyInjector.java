package com.tregula.graedukacyjna.di;

import com.tregula.graedukacyjna.domain.concurrent.GameSchedulers;

public enum DependencyInjector {
    INSTANCE;

    private Dependencies dependencies = new Dependencies();

    public GameSchedulers getGameSchedulers() {
        return dependencies.schedulers();
    }
}
