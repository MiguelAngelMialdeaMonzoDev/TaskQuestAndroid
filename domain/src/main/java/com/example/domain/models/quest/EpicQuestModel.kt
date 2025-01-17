package com.example.domain.models.quest

data class EpicQuestModel(
    val quest: QuestModel,
    val timeRemaining: String,
    val rewards: List<QuestRewardModel>
)