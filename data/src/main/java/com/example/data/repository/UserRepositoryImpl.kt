package com.example.data.repository

import com.example.domain.models.UserStatsModel
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl : UserRepository {
    override suspend fun getUserStats(): Flow<UserStatsModel> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUserStats(userStats: UserStatsModel): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun addExperience(points: Int): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun updateStreak(): Result<Unit> {
        TODO("Not yet implemented")
    }

    override fun observeUserStats(): Flow<UserStatsModel> {
        TODO("Not yet implemented")
    }

}