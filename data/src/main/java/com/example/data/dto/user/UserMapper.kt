package com.example.data.dto.user

import com.example.domain.models.user.UserMilestoneModel
import com.example.domain.models.user.UserModel
import com.example.domain.models.user.UserProgressModel
import com.example.domain.models.user.UserStatsModel

fun UserDto.toDomain() = UserModel(
    id = id,
    username = username,
    level = level,
    currentXP = currentXP,
    requiredXP = requiredXP,
    title = title,
    stats = stats.toDomain(),
    milestone = milestone.toDomain()
)

fun UserStatsDto.toDomain() = UserStatsModel(
    userId = userId,
    health = health,
    maxHealth = maxHealth,
    focus = focus,
    maxFocus = maxFocus,
    energy = energy,
    maxEnergy = maxEnergy,
    stamina = stamina,
    maxStamina = maxStamina
)

fun UserMilestoneDto.toDomain() = UserMilestoneModel(
    level = level,
    title = title,
    xpRequired = xpRequired,
    unlocksAt = unlocksAt
)

fun UserProgressDto.toDomain() = UserProgressModel(
    userId = userId,
    level = level,
    currentXP = currentXP,
    requiredXP = requiredXP,
    currentTitle = currentTitle,
    stats = stats.toDomain()
)