package com.example.data.dto.quest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quests")
data class QuestDto(
    @PrimaryKey
    val id: String,
    val title: String,
    val type: String,
    val startTime: String,
    val endTime: String,
    val xpReward: Int,
    val gemReward: Int?,
    val titleReward: String?,
    val energyReward: Int?,
    val tags: String, // Stored as comma-separated string
    val isCompleted: Boolean = false
)