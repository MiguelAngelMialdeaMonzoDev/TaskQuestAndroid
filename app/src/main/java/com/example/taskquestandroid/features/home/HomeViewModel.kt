package com.example.taskquestandroid.features.home

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.QuestModel
import com.example.domain.models.TaskModel
import com.example.domain.models.UserStatsModel
import com.example.domain.usecase.QuestUseCases
import com.example.domain.usecase.TaskUseCases
import com.example.domain.usecase.UserUseCases
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val taskUseCases: TaskUseCases,
    private val userUseCases: UserUseCases,
    private val questUseCases: QuestUseCases
) : ViewModel() {

    /*// Estados UI
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    // Estados individuales para cada sección
    private val _userStats = MutableStateFlow<UserStatsModel?>(null)
    val userStats: StateFlow<UserStatsModel?> = _userStats.asStateFlow()

    private val _dailyTasks = MutableStateFlow<List<TaskModel>>(emptyList())
    val dailyTasks: StateFlow<List<TaskModel>> = _dailyTasks.asStateFlow()

    private val _weeklyQuests = MutableStateFlow<List<QuestModel>>(emptyList())
    val weeklyQuests: StateFlow<List<QuestModel>> = _weeklyQuests.asStateFlow()

    init {
        loadInitialData()
        observeChanges()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            try {
                // Cargar datos iniciales
                _uiState.update { it.copy(isLoading = true) }

                launch { loadUserStats() }
                launch { loadDailyTasks() }
                launch { loadWeeklyQuests() }

                _uiState.update { it.copy(isLoading = false) }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Error desconocido"
                    )
                }
            }
        }
    }

    private suspend fun loadUserStats() {
        userUseCases.getUserStats()
            .catch { e ->
                _uiState.update {
                    it.copy(error = "Error al cargar estadísticas: ${e.message}")
                }
            }
            .collect { stats ->
                _userStats.value = stats
            }
    }

    private suspend fun loadDailyTasks() {
        taskUseCases.getDailyTasks()
            .catch { e ->
                _uiState.update {
                    it.copy(error = "Error al cargar tareas: ${e.message}")
                }
            }
            .collect { tasks ->
                _dailyTasks.value = tasks
            }
    }

    private suspend fun loadWeeklyQuests() {
        questUseCases.getWeeklyQuests()
            .catch { e ->
                _uiState.update {
                    it.copy(error = "Error al cargar misiones: ${e.message}")
                }
            }
            .collect { quests ->
                _weeklyQuests.value = quests
            }
    }

    private fun observeChanges() {
        viewModelScope.launch {
            // Observar cambios en tareas
            taskUseCases.observeTaskUpdates()
                .collect { updatedTask ->
                    updateTask(updatedTask)
                }
        }

        viewModelScope.launch {
            // Observar cambios en stats
            userUseCases.observeUserStats()
                .collect { stats ->
                    _userStats.value = stats
                }
        }
    }

    fun toggleTaskCompletion(taskId: String) {
        viewModelScope.launch {
            try {
                val task = _dailyTasks.value.find { it.id == taskId } ?: return@launch
                taskUseCases.toggleTaskCompletion(taskId, !task.isCompleted)

                // Actualizar experiencia si la tarea se completó
                if (!task.isCompleted) {
                    userUseCases.addExperience(task.expPoints)
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = "Error al actualizar tarea: ${e.message}")
                }
            }
        }
    }

    private fun updateTask(updatedTask: TaskModel) {
        val currentTasks = _dailyTasks.value.toMutableList()
        val index = currentTasks.indexOfFirst { it.id == updatedTask.id }
        if (index != -1) {
            currentTasks[index] = updatedTask
            _dailyTasks.value = currentTasks
        }
    }

    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }

    // Estados UI
    data class HomeUiState(
        val isLoading: Boolean = false,
        val error: String? = null
    )*/
}