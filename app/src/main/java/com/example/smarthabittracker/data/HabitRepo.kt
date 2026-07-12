package com.example.smarthabittracker.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HabitRepo @Inject constructor(
    val habitDao : HabitDao
) {
    fun getAll(): Flow<List<HabitItem>> {
        return habitDao.getAll()
    }
    suspend fun insertNewHabit(item: HabitItem) {
        habitDao.insertNewHabit(item)
    }

    fun getCount(): Flow<Int> {
        return habitDao.getNumberOfHabits()
    }
    suspend fun deleteHabitById(habitId: Int) {
        habitDao.deleteHabitById(habitId)
    }
}