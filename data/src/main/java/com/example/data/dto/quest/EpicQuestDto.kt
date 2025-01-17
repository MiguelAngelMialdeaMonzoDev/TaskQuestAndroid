package com.example.data.dto.quest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "epic_quests")
data class EpicQuestDto(
    @PrimaryKey
    val questId: String,
    val timeRemaining: String
)