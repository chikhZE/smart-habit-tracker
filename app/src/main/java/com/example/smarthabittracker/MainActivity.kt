package com.example.smarthabittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smarthabittracker.screens.HomeScreen
import com.example.smarthabittracker.screens.NavBottom
import com.example.smarthabittracker.ui.theme.SmartHabitTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartHabitTrackerTheme {
                myApp()
            }
        }
    }
}

@Composable
fun myApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {NavBottom()}
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home_screen"
        ) {
            composable("home_screen") {
                HomeScreen(
                    modifier = Modifier
                        .padding(innerPadding)
                )
            }
            composable("statistics_screen") {

            }
            composable("add_screen") {

            }
            composable("settings_screen") {

            }
        }
    }
}

