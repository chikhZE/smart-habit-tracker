package com.example.smarthabittracker.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.CleanHands
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.DirectionsRun
import androidx.compose.material.icons.outlined.Eco
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Hotel
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.LaptopMac
import androidx.compose.material.icons.outlined.LocalAtm
import androidx.compose.material.icons.outlined.LocalCafe
import androidx.compose.material.icons.outlined.LocalPizza
import androidx.compose.material.icons.outlined.Medication
import androidx.compose.material.icons.outlined.Mosque
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material.icons.outlined.PhoneAndroid
import androidx.compose.material.icons.outlined.Savings
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.SelfImprovement
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.SmokeFree
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.ui.graphics.Color
val habitIcons = listOf(
    Icons.Outlined.WaterDrop,
    Icons.Outlined.WbSunny,
    Icons.Outlined.Book,
    Icons.Outlined.FitnessCenter,
    Icons.Outlined.DirectionsRun,
    Icons.Outlined.Hotel,
    Icons.Outlined.LocalCafe,
    Icons.Outlined.SmokeFree,
    Icons.Outlined.SelfImprovement,
    Icons.Outlined.Code,
    Icons.Outlined.Language,
    Icons.Outlined.Brush,
    Icons.Outlined.MusicNote,
    Icons.Outlined.Fastfood,
    Icons.Outlined.CheckCircle,
    Icons.Outlined.Create,
    Icons.Outlined.Timer,
    Icons.Outlined.Savings,
    Icons.Outlined.ShoppingCart,
    Icons.Outlined.Medication,
    Icons.Outlined.Pets,
    Icons.Outlined.CleanHands,
    Icons.Outlined.Eco,
    Icons.Outlined.Schedule,
    Icons.Outlined.LaptopMac,
    Icons.Outlined.PhoneAndroid,
    Icons.Outlined.Favorite,
    Icons.Outlined.Star,
    Icons.Outlined.Home,
    Icons.Outlined.LocalPizza,
    Icons.Outlined.LocalAtm,
    Icons.Outlined.Mosque,
)


fun getColorFromNum(num: Int): Color {
    return when (num) {
        in 0..30 -> Color.Red
        in 31..60 -> Color.Yellow
        else -> Color.Green
    }
}