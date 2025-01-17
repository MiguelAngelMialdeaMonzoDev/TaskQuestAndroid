package com.example.domain.models.quest

data class DailyQuestsModel(
    val completedQuests: Int,
    val totalQuests: Int,
    val quests: List<QuestModel>
)