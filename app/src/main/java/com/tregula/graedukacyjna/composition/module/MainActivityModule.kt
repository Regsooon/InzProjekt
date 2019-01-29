package com.tregula.graedukacyjna.composition.module

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.tregula.graedukacyjna.MainActivity
import com.tregula.graedukacyjna.navigation.FragmentGameNavigation
import com.tregula.graedukacyjna.navigation.FragmentNavigator
import com.tregula.graedukacyjna.navigation.GameNavigation
import com.tregula.graedukacyjna.navigation.Navigator
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun bindsFragmentActivity(mainActivity: MainActivity): FragmentActivity

    @Binds
    abstract fun bindFragmentNavigator(fragmentNavigator: FragmentNavigator): Navigator<Fragment>

    @Binds
    abstract fun gameNavigation(fragmentGameNavigation: FragmentGameNavigation): GameNavigation
}