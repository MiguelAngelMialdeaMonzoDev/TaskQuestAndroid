package com.example.data.dto.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_progress")
data class UserProgressDto(
    @PrimaryKey
    val userId: String,
    val level: Int,
    val currentXP: Int,
    val requiredXP: Int,
    val currentTitle: String,
    val stats: UserStatsDto
)