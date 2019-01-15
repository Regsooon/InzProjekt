package com.tregula.graedukacyjna.composition.module;

import com.tregula.graedukacyjna.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    public abstract MainActivity bindMainActivity();
}
