package com.example.data.dto.quest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_quests")
data class DailyQuestsDto(
    @PrimaryKey
    val date: String,
    val completedQuests: Int,
    val totalQuests: Int
)