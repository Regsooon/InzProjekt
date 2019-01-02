package com.tregula.graedukacyjna.di;

import com.tregula.graedukacyjna.domain.concurrent.EducationGameSchedulers;
import com.tregula.graedukacyjna.domain.concurrent.GameSchedulers;

public class Dependencies {

    private GameSchedulers gameSchedulers;

    private final Object synchronisationObject = new Object();

    public GameSchedulers schedulers() {
        synchronized (synchronisationObject){
            if(gameSchedulers == null){
                gameSchedulers = new EducationGameSchedulers();
            }
            return gameSchedulers;
        }
    }
}
