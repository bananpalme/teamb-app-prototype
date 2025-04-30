package com.example.teamb_app_prototype.ui.theme


import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamb_app_prototype.R
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TeambappprototypeTheme {
                PlanlaegOvnScreen(

                )

            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlanlaegOvnScreen(modifier: Modifier = Modifier) {
    var tidligstText by remember { mutableStateOf("Tidligst: dato: 1/05 og kl: 08:45") }
    var senestText by remember { mutableStateOf("Senest: dato: 2/05 og kl: 01:30") }
    var varighedText by remember { mutableStateOf("") }
    var natText by remember { mutableStateOf("Vis tider om natten") }
    var switchState by remember { mutableStateOf(false) }
    var hovedText by remember { mutableStateOf("Billigste tid (-4,1kr) inden kl. 12.00 i morgen:") }
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->

        Column(
            modifier = modifier
                .padding(paddingValues)
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // -- Øverste række med ikon og titel --
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                    Image(
                        painter = painterResource(R.drawable.arrow), contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                (context as? Activity)?.finish()
                            }

                    )

                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Planlæg Apparat",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.weight(1f)
                )
            }

            // -- Tidligst og Senest bokse --
            listOf(tidligstText to { tidligstText = openDateTimePicker().toString() },
                senestText to { senestText = openDateTimePicker().toString() }
            ).forEach { (text, onClick) ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(12.dp))
                        .padding(16.dp)
                        .clickable(onClick = onClick)
                ) {
                    Text(text = text, style = MaterialTheme.typography.bodyLarge)
                }
            }

            // -- Varighed input --
            OutlinedTextField(
                value = varighedText,
                onValueChange = { varighedText = it },
                label = { Text("Varighed tid - 00:00") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            // -- Nat-tider toggle --
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.moonstar),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = natText,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Switch(
                    checked = switchState,
                    onCheckedChange = { switchState = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        uncheckedThumbColor = Color.LightGray,
                    )
                )
            }
            //--finde tid knap --
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Når du trykke her kan du selv vælg tid")
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = "Finde Tid")
                }

            }

            // -- Hovedtekst og Planlæg-knap --
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color.Black, RoundedCornerShape(12.dp))
                    .padding(30.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = hovedText,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Button(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Din planlægning er nu gennemført")
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(text = "Planlæg")
                    }
                }
            }
        }
    }
}







@Composable
fun Icon(arrowBack: Any, contentDescription: String, imageVector: Any) {
    TODO("Not yet implemented")
}

@Composable
fun IconButton(onClick: () -> Unit, content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}


fun openDateTimePicker(): Any {
    TODO("Not yet implemented")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TeambappprototypeTheme {
        PlanlaegOvnScreen(

        )
    }
}