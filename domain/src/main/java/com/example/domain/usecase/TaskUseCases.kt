package com.example.domain.usecase

import com.example.domain.models.TaskModel
import com.example.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

interface TaskUseCases {
    suspend fun getDailyTasks(): Flow<List<TaskModel>>
    suspend fun getTaskById(id: String): Result<TaskModel>
    suspend fun createTask(task: TaskModel): Result<Unit>
    suspend fun updateTask(task: TaskModel): Result<Unit>
    suspend fun toggleTaskCompletion(taskId: String, completed: Boolean): Result<Unit>
    suspend fun deleteTask(taskId: String): Result<Unit>
    fun observeTaskUpdates(): Flow<TaskModel>
}

class TaskUseCasesImpl(
    private val taskRepository: TaskRepository
) : TaskUseCases {
    override suspend fun getDailyTasks(): Flow<List<TaskModel>> =
        taskRepository.getDailyTasks()

    override suspend fun getTaskById(id: String): Result<TaskModel> =
        taskRepository.getTaskById(id)

    override suspend fun createTask(task: TaskModel): Result<Unit> =
        taskRepository.createTask(task)

    override suspend fun updateTask(task: TaskModel): Result<Unit> =
        taskRepository.updateTask(task)

    override suspend fun toggleTaskCompletion(taskId: String, completed: Boolean): Result<Unit> =
        taskRepository.toggleTaskCompletion(taskId, completed)

    override suspend fun deleteTask(taskId: String): Result<Unit> =
        taskRepository.deleteTask(taskId)

    override fun observeTaskUpdates(): Flow<TaskModel> =
        taskRepository.observeTaskUpdates()
}