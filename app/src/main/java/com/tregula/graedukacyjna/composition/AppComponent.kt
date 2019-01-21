package com.tregula.graedukacyjna.composition

import android.app.Application
import com.tregula.graedukacyjna.EducationGame
import com.tregula.graedukacyjna.composition.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    FragmentBindingModule::class,
    ConcurrentModule::class,
    DatabaseModule::class,
    ConvertersModule::class,
    ServiceBindingModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(educationGame: EducationGame)
}
