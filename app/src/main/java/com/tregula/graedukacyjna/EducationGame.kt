package com.tregula.graedukacyjna

import android.app.Activity
import android.app.Application
import android.content.Intent
import com.tregula.graedukacyjna.composition.DaggerAppComponent
import com.tregula.graedukacyjna.services.UpdateApplicationService
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class EducationGame : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
        startDatabaseUpdate()
    }

    private fun startDatabaseUpdate() {
        startService(Intent(this, UpdateApplicationService::class.java))
    }

    override fun activityInjector(): AndroidInjector<Activity> =
            activityInjector
}
