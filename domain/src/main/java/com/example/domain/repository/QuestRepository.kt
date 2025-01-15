package com.example.domain.repository

import com.example.domain.models.QuestModel
import kotlinx.coroutines.flow.Flow

interface QuestRepository {
    suspend fun getWeeklyQuests(): Flow<List<QuestModel>>
    suspend fun getQuestById(id: String): Result<QuestModel>
    suspend fun updateQuestProgress(questId: String, progress: Float): Result<Unit>
    suspend fun completeQuest(questId: String): Result<Unit>
}