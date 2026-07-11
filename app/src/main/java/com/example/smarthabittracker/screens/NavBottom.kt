package com.example.smarthabittracker.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.StackedLineChart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smarthabittracker.R
import com.example.smarthabittracker.ui.theme.PrimaryColor

@Preview
@Composable
fun NavBottom() {
    NavigationBar(
        containerColor = PrimaryColor,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = true,
            onClick = {  },

            icon = { Icon(Icons.Filled.Home, contentDescription = null, tint = Color.White) },
            label = { Text(text = stringResource(R.string.home), color = Color.White) }
        )
        NavigationBarItem(
            selected = true,
            onClick = {  },

            icon = { Icon(Icons.Filled.StackedLineChart, contentDescription = null, tint = Color.White) },
            label = { Text(text = stringResource(R.string.statistics), color = Color.White) }
        )
        NavigationBarItem(
            selected = true,
            onClick = {  },

            icon = { Icon(Icons.Filled.Add, contentDescription = null, tint = Color.White) },
            label = { Text(text = stringResource(R.string.add), color = Color.White) }
        )
        NavigationBarItem(
            selected = true,
            onClick = {  },

            icon = { Icon(Icons.Filled.Settings, contentDescription = null, tint = Color.White) },
            label = { Text(text = stringResource(R.string.settings), color = Color.White) }
        )
    }
}