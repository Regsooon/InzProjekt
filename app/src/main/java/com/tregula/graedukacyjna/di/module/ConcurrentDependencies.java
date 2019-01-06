package com.tregula.graedukacyjna.di.module;

import com.tregula.graedukacyjna.domain.concurrent.EducationGameSchedulers;
import com.tregula.graedukacyjna.domain.concurrent.GameSchedulers;

public class ConcurrentDependencies {

    private final GameSchedulers gameSchedulers = new EducationGameSchedulers();

    public GameSchedulers schedulers() {
        return gameSchedulers;
    }
}
