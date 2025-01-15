package com.example.domain.repository

import com.example.domain.models.UserStatsModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserStats(): Flow<UserStatsModel>
    suspend fun updateUserStats(userStats: UserStatsModel): Result<Unit>
    suspend fun addExperience(points: Int): Result<Unit>
    suspend fun updateStreak(): Result<Unit>
    fun observeUserStats(): Flow<UserStatsModel>
}