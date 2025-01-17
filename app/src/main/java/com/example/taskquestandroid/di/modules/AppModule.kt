package com.example.taskquestandroid.di.modules

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    // Dependencias específicas de la app
    single { androidContext().resources }
    // Otros componentes de la app...
}