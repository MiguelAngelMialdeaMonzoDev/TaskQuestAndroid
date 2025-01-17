package com.example.domain.models.user

data class UserModel(
    val id: String,
    val username: String,
    val level: Int,
    val currentXP: Int,
    val requiredXP: Int,
    val title: String,
    val stats: UserStatsModel,
    val milestone: UserMilestoneModel
)