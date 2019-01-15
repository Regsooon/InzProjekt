package com.tregula.graedukacyjna.composition;

import android.app.Application;

import com.tregula.graedukacyjna.EducationGame;
import com.tregula.graedukacyjna.composition.module.ApplicationModule;
import com.tregula.graedukacyjna.composition.module.ConcurrentModule;
import com.tregula.graedukacyjna.composition.module.DatabaseModule;
import com.tregula.graedukacyjna.composition.module.FragmentBindingModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        FragmentBindingModule.class,
        ConcurrentModule.class,
        DatabaseModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(EducationGame educationGame);
}
