package com.tregula.graedukacyjna.di;

import android.content.Context;

import com.tregula.graedukacyjna.domain.concurrent.GameSchedulers;
import com.tregula.graedukacyjna.domain.database.CapitolsDatabase;

public interface DependencyGraph {

    Context provideContext();

    GameSchedulers provideGameSchedulers();

    CapitolsDatabase provideCapitolsDatabase();
}
