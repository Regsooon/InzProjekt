package com.tregula.graedukacyjna.composition.module;

import com.tregula.graedukacyjna.question.QuestionFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    public abstract QuestionFragment bindsQuestionFragment();
}
