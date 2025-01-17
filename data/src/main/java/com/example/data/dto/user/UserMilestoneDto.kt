package com.example.data.dto.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_milestones")
data class UserMilestoneDto(
    @PrimaryKey
    val level: Int,
    val title: String,
    val xpRequired: Int,
    val unlocksAt: Int
)