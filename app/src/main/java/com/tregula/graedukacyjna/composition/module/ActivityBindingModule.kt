package com.tregula.graedukacyjna.composition.module

import com.tregula.graedukacyjna.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity
}
