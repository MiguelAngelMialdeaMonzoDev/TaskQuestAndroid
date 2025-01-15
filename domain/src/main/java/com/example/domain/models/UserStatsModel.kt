package com.example.domain.models

data class UserStatsModel(
    val id: String,
    val username: String,
    val level: Int,
    val experience: Int,
    val streak: Int,
    val totalTasksCompleted: Int = 0,
    val questsCompleted: Int = 0
)