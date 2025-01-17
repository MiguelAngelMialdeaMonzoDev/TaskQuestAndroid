package com.example.data.di.modules

import androidx.room.Room
import com.example.data.local.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "taskquest_database"
        ).build()
    }
    single { get<AppDatabase>().questDao() }
    single { get<AppDatabase>().userStatsDao() }
}