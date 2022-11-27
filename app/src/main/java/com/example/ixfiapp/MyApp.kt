package com.example.ixfiapp

import android.app.Application
import com.example.ixfiapp.di.ApplicationComponent
import com.example.ixfiapp.di.DaggerApplicationComponent

class MyApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}