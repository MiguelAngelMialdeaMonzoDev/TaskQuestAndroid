package com.example.data.local.dao.quest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.dto.quest.DailyQuestsDto
import com.example.data.dto.quest.EpicQuestDto
import com.example.data.dto.quest.QuestDto
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestDao {
    @Query("SELECT * FROM quests WHERE type = 'daily' AND date(startTime) = date('now')")
    fun getDailyQuests(): Flow<List<QuestDto>>

    @Query("SELECT * FROM quests WHERE type = 'epic' AND isCompleted = 0")
    fun getCurrentEpicQuest(): Flow<QuestDto?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuest(quest: QuestDto)

    @Update
    suspend fun updateQuest(quest: QuestDto)

    @Query("UPDATE quests SET isCompleted = 1 WHERE id = :questId")
    suspend fun completeQuest(questId: String)

    @Query("SELECT * FROM daily_quests WHERE date = date('now')")
    fun getDailyQuestsProgress(): Flow<DailyQuestsDto?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpicQuest(epicQuest: EpicQuestDto)
}