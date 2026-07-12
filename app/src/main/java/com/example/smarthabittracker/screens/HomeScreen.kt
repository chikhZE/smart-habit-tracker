package com.example.smarthabittracker.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.smarthabittracker.data.HabitViewModel
import com.example.smarthabittracker.data.habitIcons
import com.example.smarthabittracker.ui.theme.PrimaryColor
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    hiltViewModel: HabitViewModel = hiltViewModel()
) {
    val habitList by hiltViewModel.habitList.collectAsState()
    val habitCount by hiltViewModel.habitCount.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .background(PrimaryColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "80%",
                fontSize = 60.sp,
                color = Color.Green
            )
            Spacer(Modifier.height(16.dp))

            Text(
                text = "8/$habitCount HABITS COMPLETE",
                color = Color.White
            )

        }
        LazyColumn(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(habitList){ item ->
                HabitCard(
                    item.name,
                    item.iconIndex,
                    onDelete = {hiltViewModel.deleteHabitById(item.id)}
                )
            }

        }

    }
}





@Composable
fun HabitCard(
    name: String = "wakeup early",
    iconIndex: Int = 0,
    onDelete: () -> Unit = {}
) {
    var isChecked by rememberSaveable { mutableStateOf(false) }
    Card(
    modifier = Modifier
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if(isChecked) Color.Green else Color.DarkGray,
            contentColor = if(isChecked) Color.Black else Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = habitIcons[iconIndex],
                contentDescription = null
            )
            Text(
                text = name,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            )
            Checkbox(
                checked = isChecked,
                onCheckedChange = {isChecked = it}
            )
            IconButton(
                onClick = {onDelete()}
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color.Red
                )
            }

        }
    }

}