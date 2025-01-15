package com.example.data.repository

import com.example.domain.models.QuestModel
import com.example.domain.repository.QuestRepository
import kotlinx.coroutines.flow.Flow

class QuestRepositoryImpl: QuestRepository {
    override suspend fun getWeeklyQuests(): Flow<List<QuestModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getQuestById(id: String): Result<QuestModel> {
        TODO("Not yet implemented")
    }

    override suspend fun updateQuestProgress(questId: String, progress: Float): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun completeQuest(questId: String): Result<Unit> {
        TODO("Not yet implemented")
    }
}