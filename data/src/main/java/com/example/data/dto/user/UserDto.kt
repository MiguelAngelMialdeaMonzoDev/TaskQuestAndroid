package com.example.data.dto.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDto(
    @PrimaryKey
    val id: String,
    val username: String,
    val level: Int,
    val currentXP: Int,
    val requiredXP: Int,
    val title: String,
    val stats: UserStatsDto,
    val milestone: UserMilestoneDto
)