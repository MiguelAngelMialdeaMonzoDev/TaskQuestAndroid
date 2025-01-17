package com.example.taskquestandroid

import android.app.Application
import com.example.data.di.dataModules
import com.example.domain.di.domainModules
import com.example.taskquestandroid.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TaskQuestApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val allModules = listOf(
            appModules,
            dataModules,
            domainModules
        ).flatten()

        startKoin {
            androidLogger()
            androidContext(this@TaskQuestApplication)
            modules(*allModules.toTypedArray())
        }
    }
}