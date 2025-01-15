package com.example.data.dto

import com.example.domain.models.QuestModel
import com.example.domain.models.QuestRequirementModel
import com.example.domain.models.QuestTypeModel
import com.example.domain.models.TaskCategoryModel
import com.example.domain.models.TaskModel
import com.example.domain.models.UserStatsModel

fun TaskDTO.toDomain(): TaskModel {
    return TaskModel(
        id = id,
        title = title,
        iconRes = iconRes,
        expPoints = expPoints,
        isCompleted = isCompleted,
        dueDate = dueDate,
        description = description,
        category = TaskCategoryModel.valueOf(category)
    )
}

fun UserStatsDTO.toDomain(): UserStatsModel {
    return UserStatsModel(
        id = id,
        username = username,
        level = level,
        experience = experience,
        streak = streak,
        totalTasksCompleted = totalTasksCompleted,
        questsCompleted = questsCompleted
    )
}

fun QuestDTO.toDomain(): QuestModel {
    return QuestModel(
        id = id,
        title = title,
        description = description,
        expReward = expReward,
        progress = progress,
        startDate = startDate,
        endDate = endDate,
        requirements = requirements.map { it.toDomain() },
        isCompleted = isCompleted
    )
}

fun QuestRequirementDto.toDomain(): QuestRequirementModel {
    return QuestRequirementModel(
        type = QuestTypeModel.valueOf(type),
        amount = amount,
        currentProgress = currentProgress
    )
}