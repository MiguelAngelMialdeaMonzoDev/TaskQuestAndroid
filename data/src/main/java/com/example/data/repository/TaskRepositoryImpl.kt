package com.example.data.repository

import com.example.domain.models.TaskModel
import com.example.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl : TaskRepository {
    override suspend fun getDailyTasks(): Flow<List<TaskModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTaskById(id: String): Result<TaskModel> {
        TODO("Not yet implemented")
    }

    override suspend fun createTask(task: TaskModel): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun updateTask(task: TaskModel): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun toggleTaskCompletion(taskId: String, completed: Boolean): Result<Unit> {
        TODO("Not yet implemented")
    }

    override fun observeTaskUpdates(): Flow<TaskModel> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTask(taskId: String): Result<Unit> {
        TODO("Not yet implemented")
    }

}
