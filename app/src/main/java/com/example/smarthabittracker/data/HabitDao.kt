package com.example.smarthabittracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Query("SELECT * FROM habit_table")
    fun getAll(): Flow<List<HabitItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewHabit(item: HabitItem)

    @Query("SELECT COUNT(*) FROM habit_table")
    fun getNumberOfHabits(): Flow<Int>

    @Query("DELETE FROM habit_table WHERE id = :habitId")
    suspend fun deleteHabitById(habitId: Int)

    @Update
    suspend fun updateHabit(item: HabitItem)

    @Query("SELECT COUNT(*) FROM habit_table WHERE isCompleted = 1")
    fun getCompletedHabits(): Flow<Int>
}