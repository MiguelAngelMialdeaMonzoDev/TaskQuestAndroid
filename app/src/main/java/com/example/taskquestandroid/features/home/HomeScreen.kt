import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.taskquestandroid.components.BottomBar
import com.example.taskquestandroid.components.TopBar
import com.example.taskquestandroid.navigation.Route

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopBar(
                title = "TaskQuest",
                showBackArrow = false,
                showCloseButton = false
            )
        },
        bottomBar = {
            val currentRoute = navController
                .currentBackStackEntryAsState().value?.destination?.route
            BottomBar(
                currentRoute = currentRoute
            ) { newRoute ->
                navController.navigate(newRoute) {
                    // Configuración de navegación para evitar múltiples copias
                    popUpTo(Route.Home.path) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Aquí irá la lógica para añadir tarea */ },
                containerColor = Color(0xFF4A148C),
                contentColor = Color.White
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = "Añadir tarea rápida"
                    )
                    Text("Tarea Rápida")
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Focus Section
            item {
                FocusCard()
            }

            // Progress Overview
            item {
                ProgressOverviewCard()
            }

            // Time Blocks
            item {
                TimeBlocksCard()
            }

            // Next Actions
            item {
                NextActionsCard()
            }
        }
    }
}

@Composable
private fun FocusCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF4A148C)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Header con Pomodoro
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "FOCO DEL DÍA",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { /* Iniciar Pomodoro */ }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Star,
                            contentDescription = "Iniciar Pomodoro",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "4h 30m restantes",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Tarea actual
            Surface(
                color = Color(0xFF5E35B1),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
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
                                checkedColor = Color(0xFF9575CD),
                                uncheckedColor = Color.White
                            )
                        )
                        Text(
                            text = "Completar propuesta de diseño",
                            color = Color.White
                        )
                    }
                    Text(
                        text = "300 XP",
                        color = Color.White.copy(alpha = 0.8f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
private fun QuickActionsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        QuickActionButton(
            icon = Icons.Rounded.Add,
            text = "Tarea Rápida",
            onClick = {}
        )
        QuickActionButton(
            icon = Icons.Rounded.Star,
            text = "Pomodoro",
            onClick = {}
        )
        QuickActionButton(
            icon = Icons.Rounded.CheckCircle,
            text = "Inbox",
            onClick = {}
        )
    }
}

@Composable
private fun QuickActionButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.width(100.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .clickable(onClick = onClick),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Surface(
                modifier = Modifier.size(32.dp),
                shape = CircleShape,
                color = Color(0xFFEDE7F6)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = text,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(16.dp),
                    tint = Color(0xFF4A148C)
                )
            }
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}

@Composable
private fun ProgressOverviewCard() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Nivel 5",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "2,450 / 3,000 XP",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Racha: 7 días",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "12 tareas hoy",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = 0.8f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = Color(0xFF4A148C),
                trackColor = Color(0xFFE0E0E0)
            )
        }
    }
}

@Composable
private fun TimeBlocksCard() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Text(
                text = "Bloques de Tiempo",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TimeBlock(
                    time = "09:00 - 10:30",
                    task = "Desarrollo Frontend",
                    state = TimeBlockState.COMPLETED
                )
                TimeBlock(
                    time = "11:00 - 12:30",
                    task = "Propuesta de diseño",
                    state = TimeBlockState.CURRENT
                )
                TimeBlock(
                    time = "14:00 - 15:30",
                    task = "Reunión de equipo",
                    state = TimeBlockState.UPCOMING
                )
            }
        }
    }
}

enum class TimeBlockState {
    COMPLETED, CURRENT, UPCOMING
}

@Composable
private fun TimeBlock(
    time: String,
    task: String,
    state: TimeBlockState
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (state == TimeBlockState.CURRENT) Color(0xFFEDE7F6)
                else Color.Transparent,
                RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(4.dp)
                .height(48.dp)
                .background(
                    when (state) {
                        TimeBlockState.COMPLETED -> Color.Green
                        TimeBlockState.CURRENT -> Color(0xFF4A148C)
                        TimeBlockState.UPCOMING -> Color.Gray
                    },
                    RoundedCornerShape(2.dp)
                )
        )
        Column {
            Text(
                text = task,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = time,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}

@Composable
private fun NextActionsCard() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Próximas Acciones",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Ver todas",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF4A148C)
                )
            }
            NextActionsList()
        }
    }
}

@Composable
private fun NextActionsList() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        NextActionItem(
            title = "Revisar documentación",
            context = "📱 Móvil",
            energyLevel = EnergyLevel.HIGH
        )
        NextActionItem(
            title = "Enviar correo a cliente",
            context = "💻 Trabajo",
            energyLevel = EnergyLevel.LOW
        )
        NextActionItem(
            title = "Actualizar Kanban",
            context = "📋 Planificación",
            energyLevel = EnergyLevel.MEDIUM
        )
    }
}

enum class EnergyLevel(val color: Color) {
    HIGH(Color.Green),
    MEDIUM(Color(0xFFFFC107)),
    LOW(Color.Red)
}

@Composable
private fun NextActionItem(
    title: String,
    context: String,
    energyLevel: EnergyLevel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
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
                    checkedColor = Color(0xFF4A148C),
                    uncheckedColor = Color.Gray
                )
            )
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = context,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(energyLevel.color, CircleShape)
        )
    }
}

private data class NavigationItem(
    val label: String,
    val icon: ImageVector,
    val selected: Boolean = false
)