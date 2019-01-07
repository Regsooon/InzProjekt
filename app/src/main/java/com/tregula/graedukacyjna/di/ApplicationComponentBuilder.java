package com.tregula.graedukacyjna.di;

import android.app.Application;

public class ApplicationComponentBuilder {

    private Application application;

    public ApplicationComponentBuilder application(Application application){
        this.application = application;
        return this;
    }

    public DependencyGraph build(){
        if(application != null){
            return new EducationDependencyGraph(application);
        }else {
            throw new IllegalArgumentException("Application instance has to be provided to the builder");
        }
    }
}
