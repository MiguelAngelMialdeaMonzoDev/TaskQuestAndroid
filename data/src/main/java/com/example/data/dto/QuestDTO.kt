package com.example.data.dto

data class QuestDTO(
    val id: String,
    val title: String,
    val description: String,
    val expReward: Int,
    val progress: Float,
    val startDate: Long,
    val endDate: Long,
    val requirements: List<QuestRequirementDto> = emptyList(),
    val isCompleted: Boolean = false
)

data class QuestRequirementDto(
    val type: String,
    val amount: Int,
    val currentProgress: Int = 0
)