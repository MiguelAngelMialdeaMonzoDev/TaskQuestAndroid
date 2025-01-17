package com.example.data.dto.quest

import com.example.domain.models.quest.DailyQuestsModel
import com.example.domain.models.quest.EpicQuestModel
import com.example.domain.models.quest.QuestModel
import com.example.domain.models.quest.QuestRewardModel

fun QuestDto.toDomain() = QuestModel(
    id = id,
    title = title,
    type = type,
    startTime = startTime,
    endTime = endTime,
    xpReward = xpReward,
    gemReward = gemReward,
    titleReward = titleReward,
    energyReward = energyReward,
    tags = tags.split(",").map { it.trim() },
    isCompleted = isCompleted
)

fun DailyQuestsDto.toDomain(quests: List<QuestModel>) = DailyQuestsModel(
    completedQuests = completedQuests,
    totalQuests = totalQuests,
    quests = quests
)

fun EpicQuestDto.toDomain(quest: QuestModel) = EpicQuestModel(
    quest = quest,
    timeRemaining = timeRemaining,
    rewards = buildList {
        quest.xpReward.takeIf { it > 0 }?.let { add(QuestRewardModel.XP(it)) }
        quest.gemReward?.takeIf { it > 0 }?.let { add(QuestRewardModel.Gems(it)) }
        quest.titleReward?.let { add(QuestRewardModel.Title(it)) }
        quest.energyReward?.takeIf { it > 0 }?.let { add(QuestRewardModel.Energy(it)) }
    }
)