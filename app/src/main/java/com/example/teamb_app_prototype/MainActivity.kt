package com.example.teamb_app_prototype



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teamb_app_prototype.ui.Forside
import com.example.teamb_app_prototype.ui.theme.PlanlaegOvnScreen
import com.example.teamb_app_prototype.ui.theme.TeambappprototypeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Lukas
            val navController = rememberNavController()
            Column {
                NavHost(navController = navController, startDestination = "forside" ) {
                    composable("forside") {
                        Forside(
                            onTilfoejClick = {
                                navController.navigate("tilfoej")
                            },
                            onApparatClick = {
                                navController.navigate("plan")
                            }
                        )
                    }
                    composable("tilfoej") {
                        TilfoejScreen(
                            onBackClick = {
                                navController.navigate("forside")
                            }
                        )
                    }
                    composable("plan") {
                        PlanlaegOvnScreen(
                            onBackClick = {
                                navController.navigate("forside")
                            }
                        )
                    }
                }
            }
        }
    }
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
        PlanlaegOvnScreen()
    }
}