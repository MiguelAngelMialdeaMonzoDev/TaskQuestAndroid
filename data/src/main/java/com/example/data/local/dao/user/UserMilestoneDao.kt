package com.example.data.local.dao.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.dto.user.UserMilestoneDto
import kotlinx.coroutines.flow.Flow

@Dao
interface UserMilestoneDao {
    @Query("SELECT * FROM user_milestones ORDER BY level ASC")
    fun getAllMilestones(): Flow<List<UserMilestoneDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMilestone(milestone: UserMilestoneDto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMilestones(milestones: List<UserMilestoneDto>)
}