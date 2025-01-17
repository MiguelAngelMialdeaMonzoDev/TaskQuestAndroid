package com.example.domain.models.user

data class UserMilestoneModel(
    val level: Int,
    val title: String,
    val xpRequired: Int,
    val unlocksAt: Int
)
