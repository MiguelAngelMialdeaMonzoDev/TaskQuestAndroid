package com.example.taskquestandroid.di.modules

import com.example.taskquestandroid.features.home.HomeViewModel
import com.example.taskquestandroid.features.onboarding.OnboardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { OnboardingViewModel() }
}