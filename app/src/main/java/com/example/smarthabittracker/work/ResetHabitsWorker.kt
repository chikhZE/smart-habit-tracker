package com.example.smarthabittracker.work

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.smarthabittracker.data.HabitDao
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class ResetHabitsWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val habitDao: HabitDao
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            habitDao.resetDailyHabits()
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}