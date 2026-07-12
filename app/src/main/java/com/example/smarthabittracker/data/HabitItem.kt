package com.example.smarthabittracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("habit_table")
data class HabitItem(
    val name: String,
    val iconIndex: Int,
    val isCompleted: Boolean = false,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

)
