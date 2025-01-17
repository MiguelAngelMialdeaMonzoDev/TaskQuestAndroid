package com.example.taskquestandroid.features.home.fab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.dto.QuestDto
import com.example.domain.models.QuestModel
import com.example.domain.models.QuestTypeModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuestViewModel @Inject constructor(
    private val questRepository: QuestRepository,
    private val userStatsRepository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<QuestUiState>(QuestUiState.Initial)
    val uiState = _uiState.asStateFlow()

    /*fun createNewQuest(quest: QuestModel) = viewModelScope.launch {
        try {
            _uiState.value = QuestUiState.Loading

            // Validar si el jugador puede crear más quests
            val activeQuestsCount = questRepository.getActiveQuestsCountByType(quest.type)

            when (quest.type) {
                QuestTypeModel.EPIC -> {
                    if (activeQuestsCount >= 1) {
                        _uiState.value = QuestUiState.Error("Solo puedes tener una Epic Quest activa")
                        return@launch
                    }
                }
                QuestTypeModel.DAILY -> {
                    if (activeQuestsCount >= 5) {
                        _uiState.value = QuestUiState.Error("Has alcanzado el límite de Daily Quests")
                        return@launch
                    }
                }

                QuestTypeModel.SUBQUEST -> TODO()
            }

            val questId = questRepository.insertQuest(quest)
            _uiState.value = QuestUiState.Success(questId)

        } catch (e: Exception) {
            _uiState.value = QuestUiState.Error("Error al crear la quest: ${e.message}")
        }
    }*/
}

sealed class QuestUiState {
    object Initial : QuestUiState()
    object Loading : QuestUiState()
    data class Success(val questId: Long) : QuestUiState()
    data class Error(val message: String) : QuestUiState()
}