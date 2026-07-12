package com.example.smarthabittracker.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HabitItem::class], version = 2, exportSchema = false)
abstract class HabitDataBase: RoomDatabase() {
    abstract fun dao(): HabitDao
}