package com.fjbg.todo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.todo.data.local.model.Category
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.data.repository.TaskRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepositoryImp,
) : ViewModel() {

    private val _taskList = MutableStateFlow(listOf<Task>())
    val taskList: StateFlow<List<Task>> = _taskList

    private val _getTask = MutableStateFlow<Task?>(null)
    val getTask: StateFlow<Task?> = _getTask

    private val _categoryList = MutableStateFlow(listOf<Category>())
    val getCategories: StateFlow<List<Category>?> = _categoryList

    init {
        viewModelScope.launch {
            repository.getTaskList().collect { list ->
                list?.let {
                    _taskList.value = it
                }
            }
        }
    }

    fun createTask(task: Task) {
        viewModelScope.launch {
            repository.createTask(task)
        }
    }


    fun getTaskById(taskId: Int) {
        viewModelScope.launch {
            repository.getTaskById(taskId).collect {
                if (it != null) {
                    _getTask.value = it
                }
            }
        }
    }

    // Category
    fun addCategory(category: Category) {
        viewModelScope.launch {
            repository.addCategory(category)
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            repository.getCategories().collect { list ->
                list?.let {
                    _categoryList.value = it
                }
            }
        }
    }

    fun deleteCategory(categoryId: Int) {
        viewModelScope.launch {
            repository.deleteCategory(categoryId)
        }
    }
}