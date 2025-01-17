import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.taskquestandroid.R
import com.example.taskquestandroid.components.BottomBar
import com.example.taskquestandroid.components.TopBar
import com.example.taskquestandroid.features.home.fab.CreateQuestDialog
import com.example.taskquestandroid.features.home.fab.NewQuestFAB
import com.example.taskquestandroid.navigation.Route
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBar(
                title = "TaskQuest",
                showBackArrow = false,
                showCloseButton = false
            )
        },
        bottomBar = {
            BottomBar(
                currentRoute = Route.Home.path
            ) { }
        },
        floatingActionButton = {
            NewQuestFAB(
                onClick = {
                    showDialog = true
                }
            )
        }
    ) { paddingValues ->

        if (showDialog) {
            CreateQuestDialog(
                onDismiss = { showDialog = false },
                onQuestCreated = {
                    showDialog = false
                    // Aquí puedes añadir lógica adicional después de crear la quest
                }
            )
        }

        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xFF1A1625))
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Character Stats Card
            item {
                CharacterStatsCard()
            }

            // Current Quest Card
            item {
                CurrentQuestCard()
            }

            // Daily Quests Card
            item {
                DailyQuestsCard()
            }
        }
    }
}

@Composable
private fun CharacterStatsCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2D2438)
        ),
        border = BorderStroke(1.dp, Color(0xFF3D3450))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Header with Level and Premium Currency
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color(0xFF4A148C), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "5",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                    Column {
                        Text(
                            text = "Warrior of Productivity",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                        Text(
                            text = "Task Master",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFFB39DDB)
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = "Premium currency",
                        tint = Color(0xFFFFD700)
                    )
                    Text(
                        text = "450",
                        color = Color(0xFFFFD700),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Stats Grid
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatItem(
                    icon = R.drawable.ic_favorite,
                    label = "Health",
                    value = "85/100",
                    color = Color(0xFFE57373)
                )
                StatItem(
                    icon = R.drawable.ic_radio_button_checked,
                    label = "Focus",
                    value = "75/100",
                    color = Color(0xFF64B5F6)
                )
                StatItem(
                    icon = R.drawable.ic_wb_sunny,
                    label = "Energy",
                    value = "60/100",
                    color = Color(0xFFFFD54F)
                )
                StatItem(
                    icon = R.drawable.ic_coffee,
                    label = "Stamina",
                    value = "40/100",
                    color = Color(0xFFFFB74D)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // XP Progress
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Level 5 - Task Master",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "2,450 / 3,000 XP",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                LinearProgressIndicator(
                    progress = 0.82f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = Color(0xFF7E57C2),
                    trackColor = Color(0xFF4A148C)
                )
            }
        }
    }
}

@Composable
private fun StatItem(
    @DrawableRes icon: Int,
    label: String,
    value: String,
    color: Color
) {
    Column(
        modifier = Modifier
            .background(Color(0xFF362F45), RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = label,
            tint = color,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            color = Color.White,
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = value,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun CurrentQuestCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2D2438)
        ),
        border = BorderStroke(1.dp, Color(0xFF3D3450))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_epic_quest),
                    contentDescription = "Epic Quest",
                    tint = Color(0xFFFFD54F)
                )
                Text(
                    text = "Epic Quest In Progress",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_timer),
                        contentDescription = "Time remaining",
                        tint = Color(0xFFFFD54F)
                    )
                    Text(
                        text = "4h 30m",
                        color = Color(0xFFB39DDB)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Current Quest
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF362F45), RoundedCornerShape(8.dp))
                    .border(1.dp, Color(0xFF4A148C), RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = false,
                                onCheckedChange = {},
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color(0xFF7E57C2),
                                    uncheckedColor = Color(0xFFB39DDB)
                                )
                            )
                            Column {
                                Text(
                                    text = "Design Proposal Quest",
                                    color = Color.White,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Surface(
                                        color = Color(0xFF4A148C),
                                        shape = RoundedCornerShape(4.dp)
                                    ) {
                                        Text(
                                            text = "Epic",
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                            color = Color.White,
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Rounded.Star,
                                            contentDescription = "XP",
                                            tint = Color(0xFFFFD54F),
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Text(
                                            text = "300 XP",
                                            color = Color(0xFFB39DDB),
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(color = Color(0xFF4A148C))
                    Spacer(modifier = Modifier.height(16.dp))

                    // Rewards
                    Text(
                        text = "Rewards:",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        RewardChip(
                            icon = R.drawable.ic_star,
                            text = "300 XP",
                            color = Color(0xFFFFD54F)
                        )
                        RewardChip(
                            icon = R.drawable.ic_diamond,
                            text = "50 Gems",
                            color = Color(0xFF64B5F6)
                        )
                        RewardChip(
                            icon = R.drawable.ic_emoji_events,
                            text = "Designer Title",
                            color = Color(0xFFFFD54F)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RewardChip(
    @DrawableRes icon: Int,
    text: String,
    color: Color
) {
    Surface(
        color = Color(0xFF4A148C),
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
private fun DailyQuestsCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2D2438)
        ),
        border = BorderStroke(1.dp, Color(0xFF3D3450))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_daily_quest),
                    contentDescription = "Daily Quest",
                    tint = Color(0xFFFFD54F)
                )
                Text(
                    text = "Daily Quests",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
                Text(
                    text = "3/5 Completed",
                    color = Color(0xFFB39DDB)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Quest items
            QuestItem(
                title = "Frontend Development",
                time = "09:00 - 10:30",
                xp = 200,
                tags = listOf("Coding", "+10 Energy"),
                status = QuestStatus.COMPLETED
            )

            Spacer(modifier = Modifier.height(8.dp))

            QuestItem(
                title = "Design Proposal",
                time = "11:00 - 12:30",
                xp = 300,
                tags = listOf("Design", "Epic Quest"),
                status = QuestStatus.ACTIVE
            )

            Spacer(modifier = Modifier.height(8.dp))

            QuestItem(
                title = "Team Meeting",
                time = "14:00 - 15:30",
                xp = 100,
                tags = listOf("Group", "+5 Social"),
                status = QuestStatus.UPCOMING
            )
        }
    }
}

enum class QuestStatus {
    COMPLETED, ACTIVE, UPCOMING
}

@Composable
private fun QuestItem(
    title: String,
    time: String,
    xp: Int,
    tags: List<String>,
    status: QuestStatus
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                when (status) {
                    QuestStatus.ACTIVE -> Color(0xFF362F45)
                    else -> Color(0xFF2D2438)
                },
                RoundedCornerShape(8.dp)
            )
            .border(
                width = if (status == QuestStatus.ACTIVE) 1.dp else 0.dp,
                color = Color(0xFF4A148C),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Status indicator bar
        Box(
            modifier = Modifier
                .width(4.dp)
                .height(48.dp)
                .background(
                    when (status) {
                        QuestStatus.COMPLETED -> Color(0xFF4CAF50)
                        QuestStatus.ACTIVE -> Color(0xFFFFD54F)
                        QuestStatus.UPCOMING -> Color(0xFF7E57C2)
                    },
                    RoundedCornerShape(2.dp)
                )
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = title,
                        color = if (status == QuestStatus.COMPLETED) Color.Gray else Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = time,
                        color = Color(0xFFB39DDB),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = "XP",
                        tint = Color(0xFFFFD54F),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "$xp XP",
                        color = Color(0xFFB39DDB),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Tags
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                tags.forEach { tag ->
                    Surface(
                        color = Color(0xFF4A148C),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = tag,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            color = Color.White,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RPGTaskQuestPreview() {
    MaterialTheme {
        HomeScreen(
            navController = rememberNavController()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterStatsCardPreview() {
    MaterialTheme {
        CharacterStatsCard()
    }
}

@Preview(showBackground = true)
@Composable
fun CurrentQuestCardPreview() {
    MaterialTheme {
        CurrentQuestCard()
    }
}

@Preview(showBackground = true)
@Composable
fun DailyQuestsCardPreview() {
    MaterialTheme {
        DailyQuestsCard()
    }
}