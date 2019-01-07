package com.tregula.graedukacyjna.di;

import android.content.Context;

import com.tregula.graedukacyjna.domain.concurrent.GameSchedulers;

public interface DependencyGraph {

    Context provideContext();

    GameSchedulers provideGameSchedulers();
}
