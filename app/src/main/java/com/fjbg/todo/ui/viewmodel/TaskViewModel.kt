package com.fjbg.todo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.data.repository.TaskRepositoryImp
import com.fjbg.todo.utils.DEBUG_TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepositoryImp
) : ViewModel() {

    private val _uiState = MutableStateFlow(TaskListState.Success(emptyList()))

    val uiState: StateFlow<TaskListState> = _uiState

    init {
        viewModelScope.launch {
            repository.getTaskList().collect { list ->

                Log.d(DEBUG_TAG, "list: $list")

                if (list != null) {
                    _uiState.value = TaskListState.Success(list)
                }
            }
        }
    }

    fun createNewTask(task: Task) {
        viewModelScope.launch {
            repository.createNewTask(task)
        }
    }

}

sealed class TaskListState {
    data class Success(val list: List<Task>) : TaskListState()
    data class Error(val exception: Throwable) : TaskListState()
}