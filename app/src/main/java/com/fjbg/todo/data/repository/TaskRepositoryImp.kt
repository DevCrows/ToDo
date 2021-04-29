package com.fjbg.todo.data.repository

import com.fjbg.todo.data.local.TaskDatabase
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.data.repository.mapper.taskEntitiesToModels
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class TaskRepositoryImp @Inject constructor(
    private val database: TaskDatabase
) : TaskRepository {

    override suspend fun getTaskList(): Flow<List<Task>?> {
        val flowTask = MutableStateFlow<List<Task>?>(null)
        database.taskDao().getActiveTaskLit().collect { entities ->
            flowTask.value = taskEntitiesToModels(entities)
        }
        return flowTask
    }

    override suspend fun createNewTask(task: Task) {
    }

    override suspend fun editTask(taskId: Int) {
    }

    override suspend fun deleteTask(taskId: Int) {
    }
}