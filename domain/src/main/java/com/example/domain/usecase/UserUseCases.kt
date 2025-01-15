package com.example.domain.usecase

import com.example.domain.models.UserStatsModel
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

interface UserUseCases {
    suspend fun getUserStats(): Flow<UserStatsModel>
    suspend fun updateUserStats(userStats: UserStatsModel): Result<Unit>
    suspend fun addExperience(points: Int): Result<Unit>
    suspend fun updateStreak(): Result<Unit>
    fun observeUserStats(): Flow<UserStatsModel>
}

class UserUseCasesImpl(
    private val userRepository: UserRepository
) : UserUseCases {
    override suspend fun getUserStats(): Flow<UserStatsModel> =
        userRepository.getUserStats()

    override suspend fun updateUserStats(userStats: UserStatsModel): Result<Unit> =
        userRepository.updateUserStats(userStats)

    override suspend fun addExperience(points: Int): Result<Unit> =
        userRepository.addExperience(points)

    override suspend fun updateStreak(): Result<Unit> =
        userRepository.updateStreak()

    override fun observeUserStats(): Flow<UserStatsModel> =
        userRepository.observeUserStats()
}