package com.example.taskquestandroid.features.home.fab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.data.dto.QuestDto
import com.example.domain.models.QuestDifficultyModel
import com.example.domain.models.QuestTypeModel
import com.example.taskquestandroid.R
import androidx.compose.material3.Card
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.domain.models.QuestModel
import com.example.domain.models.QuestStatusModel

@Composable
fun NewQuestFAB(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icono Plus con efecto de pulso
            Box(
                modifier = Modifier
                    .background(
                        color = Color(0x4DFFD700),
                        shape = CircleShape
                    )
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null,
                    tint = Color(0xFFFFD700)
                )
            }

            // Texto
            Text(
                text = "Nueva Quest",
                color = Color.White,
                style = MaterialTheme.typography.labelLarge
            )

            // Icono decorativo de espada
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_sword),
                contentDescription = null,
                tint = Color(0xFFE0E0E0),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun CreateQuestDialog(
    onDismiss: () -> Unit,
    onQuestCreated: () -> Unit,
    //viewModel: QuestViewModel
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var type by remember { mutableStateOf(QuestTypeModel.DAILY) }
    var difficulty by remember { mutableStateOf(QuestDifficultyModel.EASY) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(24.dp),
            color = Color(0xFF311B92)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu_book),
                        contentDescription = null,
                        tint = Color(0xFFFFEE58),
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = "Nueva Aventura",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color(0xFFFFEE58)
                    )
                }

                // Title Input
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    placeholder = {
                        Text("Título de tu misión", color = Color(0xFFD1C4E9))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFF9575CD),
                        focusedBorderColor = Color(0xFFFFEE58),
                        unfocusedContainerColor = Color(0xFF4527A0).copy(alpha = 0.5f),
                        focusedContainerColor = Color(0xFF4527A0).copy(alpha = 0.5f)
                    ),
                    textStyle = LocalTextStyle.current.copy(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )

                // Description Input
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    placeholder = {
                        Text("Describe tu misión...", color = Color(0xFFD1C4E9))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFF9575CD),
                        focusedBorderColor = Color(0xFFFFEE58),
                        unfocusedContainerColor = Color(0xFF4527A0).copy(alpha = 0.5f),
                        focusedContainerColor = Color(0xFF4527A0).copy(alpha = 0.5f)
                    ),
                    textStyle = LocalTextStyle.current.copy(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )

                // Quest Type
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        QuestTypeButton(
                            text = "Daily",
                            icon = ImageVector.vectorResource(R.drawable.ic_shield),
                            selected = type == QuestTypeModel.DAILY,
                            selectedColor = Color(0xFF42A5F5),
                            onClick = { type = QuestTypeModel.DAILY },
                            modifier = Modifier.weight(1f)
                        )
                        QuestTypeButton(
                            text = "Epic",
                            icon = ImageVector.vectorResource(R.drawable.ic_auto_awesome),
                            selected = type == QuestTypeModel.EPIC,
                            selectedColor = Color(0xFFFFEE58),
                            onClick = { type = QuestTypeModel.EPIC },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // Difficulty
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Dificultad",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFFBB86FC),
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        DifficultyButton(
                            text = "Fácil",
                            starCount = 1,
                            selected = difficulty == QuestDifficultyModel.EASY,
                            selectedColor = Color(0xFF66BB6A),
                            onClick = { difficulty = QuestDifficultyModel.EASY },
                            modifier = Modifier.weight(1f)
                        )
                        DifficultyButton(
                            text = "Media",
                            starCount = 2,
                            selected = difficulty == QuestDifficultyModel.MEDIUM,
                            selectedColor = Color(0xFFFFEE58),
                            onClick = { difficulty = QuestDifficultyModel.MEDIUM },
                            modifier = Modifier.weight(1f)
                        )
                        DifficultyButton(
                            text = "Difícil",
                            starCount = 3,
                            selected = difficulty == QuestDifficultyModel.HARD,
                            selectedColor = Color(0xFFEF5350),
                            onClick = { difficulty = QuestDifficultyModel.HARD },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // Action Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    TextButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Color(0xFFD1C4E9)
                        )
                    ) {
                        Text("Cancelar")
                    }
                    Button(
                        onClick = {
                            /*val newQuest = QuestModel(
                                title = title,
                                description = description,
                                type = type,
                                difficulty = difficulty,
                                xpReward = calculateXpReward(type, difficulty),
                                createdAt = System.currentTimeMillis(),
                                status = QuestStatusModel.ACTIVE,
                                deadline = null,
                                completionDate = null,
                                parentQuestId = null
                            )
                            viewModel.createNewQuest(newQuest)
                            onQuestCreated()*/
                        },
                        enabled = title.isNotBlank() && description.isNotBlank(),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (title.isNotBlank() && description.isNotBlank())
                                Color(0xFFFFEE58) else Color(0xFFFFEE58).copy(alpha = 0.5f),
                            contentColor = Color(0xFF311B92)
                        )
                    ) {
                        Text("Empezar", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun QuestTypeButton(
    text: String,
    icon: ImageVector,
    selected: Boolean,
    selectedColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        modifier = modifier
            .height(48.dp)
            .border(
                width = 2.dp,
                color = if (selected) selectedColor else Color(0xFF9575CD),
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        color = if (selected) selectedColor.copy(alpha = 0.2f) else Color(0xFF4527A0).copy(alpha = 0.3f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (selected) selectedColor else Color(0xFFD1C4E9),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                color = if (selected) selectedColor else Color(0xFFD1C4E9)
            )
        }
    }
}

@Composable
fun DifficultyButton(
    text: String,
    starCount: Int,
    selected: Boolean,
    selectedColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        modifier = modifier
            .height(64.dp)
            .border(
                width = 2.dp,
                color = if (selected) selectedColor else Color(0xFF9575CD),
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        color = if (selected) selectedColor.copy(alpha = 0.2f) else Color(0xFF4527A0).copy(alpha = 0.3f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(bottom = 4.dp)
            ) {
                repeat(starCount) {
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = null,
                        tint = if (selected) selectedColor else Color(0xFFD1C4E9),
                        modifier = Modifier.size(16.dp)
                    )
                    if (it < starCount - 1) {
                        Spacer(modifier = Modifier.width(2.dp))
                    }
                }
            }
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = if (selected) selectedColor else Color(0xFFD1C4E9)
            )
        }
    }
}

private fun calculateXpReward(type: QuestTypeModel, difficulty: QuestDifficultyModel): Int {
    val baseXp = when (type) {
        QuestTypeModel.DAILY -> 100
        QuestTypeModel.EPIC -> 300
        QuestTypeModel.SUBQUEST -> 50
    }

    val multiplier = when (difficulty) {
        QuestDifficultyModel.EASY -> 1.0
        QuestDifficultyModel.MEDIUM -> 1.5
        QuestDifficultyModel.HARD -> 2.0
    }

    return (baseXp * multiplier).toInt()
}