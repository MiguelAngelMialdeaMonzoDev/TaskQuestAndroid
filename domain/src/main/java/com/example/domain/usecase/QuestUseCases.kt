package com.example.domain.usecase

import com.example.domain.models.QuestModel
import com.example.domain.repository.QuestRepository
import kotlinx.coroutines.flow.Flow

interface QuestUseCases {
    suspend fun getWeeklyQuests(): Flow<List<QuestModel>>
    suspend fun getQuestById(id: String): Result<QuestModel>
    suspend fun updateQuestProgress(questId: String, progress: Float): Result<Unit>
    suspend fun completeQuest(questId: String): Result<Unit>
}

class QuestUseCasesImpl(
    private val questRepository: QuestRepository
) : QuestUseCases {
    override suspend fun getWeeklyQuests(): Flow<List<QuestModel>> =
        questRepository.getWeeklyQuests()

    override suspend fun getQuestById(id: String): Result<QuestModel> =
        questRepository.getQuestById(id)

    override suspend fun updateQuestProgress(questId: String, progress: Float): Result<Unit> =
        questRepository.updateQuestProgress(questId, progress)

    override suspend fun completeQuest(questId: String): Result<Unit> =
        questRepository.completeQuest(questId)
}