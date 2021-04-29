package com.fjbg.todo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.data.repository.TaskRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TaskRepositoryImp
) : ViewModel() {

    private val _uiState = MutableStateFlow(TaskListState.Success(emptyList()))

    val uiState: StateFlow<TaskListState> = _uiState

    init {
        viewModelScope.launch {
            repository.getTaskList().collectLatest { list ->
                if (list != null) {
                    _uiState.value = TaskListState.Success(list)
                }
            }
        }
    }
}

sealed class TaskListState {
    data class Success(val list: List<Task>) : TaskListState()
    data class Error(val exception: Throwable) : TaskListState()
}