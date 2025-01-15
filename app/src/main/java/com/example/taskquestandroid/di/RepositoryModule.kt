package com.example.taskquestandroid.di

import com.example.data.repository.QuestRepositoryImpl
import com.example.data.repository.TaskRepositoryImpl
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.QuestRepository
import com.example.domain.repository.TaskRepository
import com.example.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<TaskRepository> { TaskRepositoryImpl() }
    single<QuestRepository> { QuestRepositoryImpl() }
    single<UserRepository> { UserRepositoryImpl() }
}