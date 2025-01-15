package com.example.domain.repository

import com.example.domain.models.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun getDailyTasks(): Flow<List<TaskModel>>
    suspend fun getTaskById(id: String): Result<TaskModel>
    suspend fun createTask(task: TaskModel): Result<Unit>
    suspend fun updateTask(task: TaskModel): Result<Unit>
    suspend fun toggleTaskCompletion(taskId: String, completed: Boolean): Result<Unit>
    fun observeTaskUpdates(): Flow<TaskModel>
    suspend fun deleteTask(taskId: String): Result<Unit>
}