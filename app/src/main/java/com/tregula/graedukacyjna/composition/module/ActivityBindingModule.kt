package com.tregula.graedukacyjna.composition.module

import com.tregula.graedukacyjna.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentBindingModule::class])
    abstract fun provideMainActivity(): MainActivity
}
