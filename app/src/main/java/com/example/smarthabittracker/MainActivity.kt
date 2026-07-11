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
    Scaffold(
        bottomBar = {NavBottom()}
    ) {innerPadding ->

    }
}

