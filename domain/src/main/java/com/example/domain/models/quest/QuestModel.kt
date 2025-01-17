package com.example.domain.models.quest


data class QuestModel(
    val id: String,
    val title: String,
    val type: String, // "Epic", "Daily", etc.
    val startTime: String,
    val endTime: String,
    val xpReward: Int,
    val gemReward: Int?,
    val titleReward: String?,
    val energyReward: Int?,
    val tags: List<String>, // "Coding", "Design", etc.
    val isCompleted: Boolean = false
)