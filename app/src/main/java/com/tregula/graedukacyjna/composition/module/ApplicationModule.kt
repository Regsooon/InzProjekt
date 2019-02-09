package com.tregula.graedukacyjna.composition.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.storage.FirebaseStorage
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    companion object {
        private const val PREFERENCES_NAME = "com.tregula.graedukacyjna.preferences"
        private const val PREFERENCES_CONTEXT = Context.MODE_PRIVATE
    }

    @Provides
    @Singleton
    fun providesContext(application: Application): Context =
            application

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage =
            FirebaseStorage.getInstance()

    @Provides
    fun provideMoshi(): Moshi =
            Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(PREFERENCES_NAME, PREFERENCES_CONTEXT)
}
