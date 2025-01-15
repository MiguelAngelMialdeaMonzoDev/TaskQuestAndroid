package com.example.data.dto

data class TaskDTO(
    val id: String,
    val title: String,
    val iconRes: Int,
    val expPoints: Int,
    val isCompleted: Boolean,
    val dueDate: Long? = null,
    val description: String? = null,
    val category: String = TaskCategoryDTO.DAILY.name
)

enum class TaskCategoryDTO {
    DAILY, WEEKLY, CUSTOM
}