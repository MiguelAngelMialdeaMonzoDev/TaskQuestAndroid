package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dto.QuestDto

@Database(
    entities = [QuestDto::class, UserStatsDto::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questDao(): QuestDao
    abstract fun userStatsDao(): UserStatsDao
}
