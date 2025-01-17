package com.example.data.dto.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_stats")
data class UserStatsDto(
    @PrimaryKey
    val userId: String,
    val health: Int,
    val maxHealth: Int,
    val focus: Int,
    val maxFocus: Int,
    val energy: Int,
    val maxEnergy: Int,
    val stamina: Int,
    val maxStamina: Int
)