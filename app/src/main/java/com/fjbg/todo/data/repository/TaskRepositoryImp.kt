package com.fjbg.todo.data.repository

import com.fjbg.todo.data.local.TaskDatabase
import com.fjbg.todo.data.local.model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepositoryImp @Inject constructor(
    private val database: TaskDatabase
) : TaskRepository {

    override fun getTaskList(): Flow<List<Task>?> {
        return database.taskDao().getActiveTaskLit()
    }
}