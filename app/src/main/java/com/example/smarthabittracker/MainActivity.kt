package com.example.smarthabittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smarthabittracker.screens.AddScreen
import com.example.smarthabittracker.screens.HomeScreen
import com.example.smarthabittracker.screens.NavBottom
import com.example.smarthabittracker.ui.theme.PrimaryColor
import com.example.smarthabittracker.ui.theme.SmartHabitTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    Scaffold(

        topBar = {
            if(currentRoute != "home_screen") {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = stringResource(R.string.add_new_habit),
                            modifier = Modifier,
                            color = Color.White
                        )},
                    colors = centerAlignedTopAppBarColors(PrimaryColor)

                )
            }

        },
        bottomBar = {NavBottom(navController)}
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
                AddScreen(
                    modifier = Modifier
                        .padding(innerPadding)
                )
            }
            composable("settings_screen") {

            }
        }
    }
}

