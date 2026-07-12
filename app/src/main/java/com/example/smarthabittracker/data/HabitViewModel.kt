package com.example.smarthabittracker.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HabitViewModel @Inject constructor(
    private val repository: HabitRepo
) : ViewModel() {

    val habitList: StateFlow<List<HabitItem>> = repository.getAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val habitCount: StateFlow<Int> = repository.getCount()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )

    val completedHabitCount: StateFlow<Int> = repository.getCompletedHabits()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )

    val completedHabitRate: StateFlow<Int> = repository.getCompletedRate()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )


     fun insertNewHabit(name: String,iconIndex: Int) {
        viewModelScope.launch {
            repository.insertNewHabit(HabitItem(name,iconIndex))
        }
    }

    fun deleteHabitById(habitId: Int) {
        viewModelScope.launch {
            repository.deleteHabitById(habitId)
        }
    }

    fun updateHabit(item: HabitItem, isChecked: Boolean) {
        viewModelScope.launch {
            val updatedItem = item.copy(isCompleted = isChecked)
            repository.updateHabit(updatedItem)
        }
    }


}