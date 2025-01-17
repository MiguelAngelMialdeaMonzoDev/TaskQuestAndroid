package com.example.data.di

import com.example.data.di.modules.databaseModule
import com.example.data.di.modules.firebaseModule
import com.example.data.di.modules.repositoryModule

val dataModules = listOf(
    databaseModule,
    repositoryModule,
    firebaseModule
)