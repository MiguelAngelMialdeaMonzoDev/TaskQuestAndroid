package com.example.domain.models

import androidx.annotation.DrawableRes

data class TaskModel(
    val id: String,
    val title: String,
    @DrawableRes val iconRes: Int,
    val expPoints: Int,
    val isCompleted: Boolean,
    val dueDate: Long? = null,
    val description: String? = null,
    val category: TaskCategoryModel = TaskCategoryModel.DAILY
)

enum class TaskCategoryModel {
    DAILY, WEEKLY, CUSTOM
}