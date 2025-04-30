package com.example.teamb_app_prototype


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Switch
import kotlinx.coroutines.launch
import androidx.compose.material.icons.filled.Info




@Composable
fun TilfoejScreen() {
    val coroutineScope = rememberCoroutineScope()
    var navn by remember { mutableStateOf("") }
    var elforbrug by remember { mutableStateOf("") }
    var afgift by remember { mutableStateOf(false) }
    var visBesked by remember { mutableStateOf(false) } // 👈 bekræftelsesflag
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val isEnabled = navn.isNotBlank() && elforbrug.isNotBlank()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)

        ) {
            // Tilbageknap + Overskrift
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /* TODO: Tilbage funktion */ }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Tilbage")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Tilføj apparat",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Navn Input
            OutlinedTextField(
                value = navn,
                onValueChange = { navn = it },
                label = { Text("Navn") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Elforbrug Input
            OutlinedTextField(
                value = elforbrug,
                onValueChange = { elforbrug = it },
                label = { Text("Elforbrug (kWh)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Afgift Toggle
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Afgift")

                Spacer(modifier = Modifier.width(8.dp))

                // Info ikon
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Info",
                    tint = Color.Gray,
                    modifier = Modifier.size(18.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Toggle-knap
                Switch(
                    checked = afgift,
                    onCheckedChange = { afgift = it }
                )
            }


            Spacer(modifier = Modifier.height(32.dp))

            // Tilføj-knap
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Apparatet er nu tilføjet")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                enabled = isEnabled,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isEnabled) Color(0xFF3B4D7A) else Color.White,
                    contentColor = if (isEnabled) Color.White else Color.Gray,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.Gray
                )
            ) {
                Text(text = "Tilføj")
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Smart opladning reklame del
            Text(
                text = "Vil du planlægge opladning af elbil?",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF007AFF),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "⚡ Smart opladning",
                            style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Oplad din bil automatisk, når strømmen er billigst 😁",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
                        )
                    }
                }

                Button(
                    onClick = { /* TODO: Læs mere funktion */ },
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RoundedCornerShape(50)
                ) {
                    Text(
                        text = "Læs mere",
                        color = Color.Black
                    )
                }
            }
        }
    }
}

// Preview
@Preview(showBackground = true)
@Composable
fun TilfoejPreview() {
    TilfoejScreen()
}
