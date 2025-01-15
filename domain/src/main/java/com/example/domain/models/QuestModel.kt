package com.example.domain.models

data class QuestModel(
    val id: String,
    val title: String,
    val description: String,
    val expReward: Int,
    val progress: Float,
    val startDate: Long,
    val endDate: Long,
    val requirements: List<QuestRequirementModel> = emptyList(),
    val isCompleted: Boolean = false
)

data class QuestRequirementModel(
    val type: QuestTypeModel,
    val amount: Int,
    val currentProgress: Int = 0
)

enum class QuestTypeModel {
    COMPLETE_TASKS,
    MAINTAIN_STREAK,
    EARN_EXPERIENCE,
    CUSTOM
}