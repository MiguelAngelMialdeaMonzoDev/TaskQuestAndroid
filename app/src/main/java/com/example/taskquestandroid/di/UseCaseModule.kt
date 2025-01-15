package com.example.taskquestandroid.di

import com.example.domain.usecase.QuestUseCases
import com.example.domain.usecase.QuestUseCasesImpl
import com.example.domain.usecase.TaskUseCases
import com.example.domain.usecase.TaskUseCasesImpl
import com.example.domain.usecase.UserUseCases
import com.example.domain.usecase.UserUseCasesImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<TaskUseCases> { TaskUseCasesImpl(get()) }
    single<UserUseCases> { UserUseCasesImpl(get()) }
    single<QuestUseCases> { QuestUseCasesImpl(get()) }
}