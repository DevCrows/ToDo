package com.fjbg.todo.data.repository

import com.fjbg.todo.data.local.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getTaskList(): Flow<List<Task>?>
}