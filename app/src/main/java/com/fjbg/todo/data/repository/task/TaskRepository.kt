package com.fjbg.todo.data.repository.task

import com.fjbg.todo.data.local.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun getTaskList(): Flow<List<Task>?>
    suspend fun createTask(task: Task)
    suspend fun getTaskById(taskId: Int): Flow<Task?>
    suspend fun editTask(taskId: Int)
    suspend fun deleteTask(taskId: Int)

}