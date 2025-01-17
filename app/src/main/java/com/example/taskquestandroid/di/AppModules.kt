package com.example.taskquestandroid.di

import com.example.taskquestandroid.di.modules.appModule
import com.example.taskquestandroid.di.modules.viewModelModule

val appModules = listOf(
    viewModelModule,
    appModule
)