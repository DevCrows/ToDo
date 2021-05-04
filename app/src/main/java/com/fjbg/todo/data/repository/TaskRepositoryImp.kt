package com.fjbg.todo.data.repository

import com.fjbg.todo.data.local.TaskDatabase
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.data.repository.mapper.entityToModel
import com.fjbg.todo.data.repository.mapper.modelToEntity
import com.fjbg.todo.data.repository.mapper.taskEntitiesToModels
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImp @Inject constructor(
    private val database: TaskDatabase
) : TaskRepository {

    override suspend fun getTaskList(): Flow<List<Task>?> {
        return database.taskDao().getActiveTaskLit().map { list ->
            list?.let { it ->
                taskEntitiesToModels(it)
            }
        }
    }

    override suspend fun createNewTask(task: Task) {
        val entity = modelToEntity(task)
        database.taskDao().addTask(entity)
    }

    override suspend fun getTaskById(taskId: Int): Flow<Task?> {
        return database.taskDao().getTaskById(taskId).map { entity ->
            entity?.let {
                entityToModel(it)
            }
        }
    }

    override suspend fun editTask(taskId: Int) {
    }

    override suspend fun deleteTask(taskId: Int) {
    }
}