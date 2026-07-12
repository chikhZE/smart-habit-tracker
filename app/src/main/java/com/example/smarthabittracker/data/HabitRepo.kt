package com.example.smarthabittracker.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
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
    suspend fun updateHabit(item: HabitItem) {
        habitDao.updateHabit(item)
    }

    fun getCompletedHabits(): Flow<Int> {
        return habitDao.getCompletedHabits()
    }

    fun getCompletedRate(): Flow<Int> {
        return combine(
            habitDao.getCompletedHabits(),
            habitDao.getNumberOfHabits()
        ) { completed, total ->
            if (total > 0) {
                (completed * 100) / total
            } else {
                100
            }
        }
    }
}