package com.example.domain.models.user

data class UserProgressModel(
    val userId: String,
    val level: Int,
    val currentXP: Int,
    val requiredXP: Int,
    val currentTitle: String,
    val stats: UserStatsModel
)