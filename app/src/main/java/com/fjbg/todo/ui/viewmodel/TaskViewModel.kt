package com.fjbg.todo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.todo.data.local.model.Category
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.data.repository.category.CategoryRepositoryImp
import com.fjbg.todo.data.repository.task.TaskRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepositoryImp,
    private val categoryRepository: CategoryRepositoryImp,
) : ViewModel() {

    private val _taskList = MutableStateFlow(listOf<Task>())
    val taskList: StateFlow<List<Task>> = _taskList

    private val _getTask = MutableStateFlow<Task?>(null)
    val getTask: StateFlow<Task?> = _getTask

    private val _categoryList = MutableStateFlow(listOf<Category>())
    val getCategories: StateFlow<List<Category>?> = _categoryList

    init {
        viewModelScope.launch {
            taskRepository.getTaskList().collect { list ->
                list?.let {
                    _taskList.value = it
                }
            }
        }
    }

    fun createTask(task: Task) {
        viewModelScope.launch {
            taskRepository.createTask(task)
        }
    }


    fun getTaskById(taskId: Int) {
        viewModelScope.launch {
            taskRepository.getTaskById(taskId).collect {
                if (it != null) {
                    _getTask.value = it
                }
            }
        }
    }

    // Category
    fun addCategory(category: Category) {
        viewModelScope.launch {
            categoryRepository.addCategory(category)
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            categoryRepository.getCategories().collect { list ->
                list?.let {
                    _categoryList.value = it
                }
            }
        }
    }

    fun getCategoryById(categoryId: Int): Category? {
        var category: Category? = null
        viewModelScope.launch {
            category = categoryRepository.getCategoryById(categoryId)
        }
        return category
    }

    fun deleteCategory(categoryId: Int) {
        viewModelScope.launch {
            categoryRepository.deleteCategory(categoryId)
        }
    }
}