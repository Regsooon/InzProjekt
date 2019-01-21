package com.tregula.graedukacyjna.composition.module

import com.tregula.graedukacyjna.services.UpdateApplicationService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBindingModule {

    @ContributesAndroidInjector
    abstract fun bindsUpdateApplicationService(): UpdateApplicationService
}