package com.example.domain.models.quest

sealed class QuestRewardModel {
    data class XP(val amount: Int) : QuestRewardModel()
    data class Gems(val amount: Int) : QuestRewardModel()
    data class Title(val title: String) : QuestRewardModel()
    data class Energy(val amount: Int) : QuestRewardModel()
}