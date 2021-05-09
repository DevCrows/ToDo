package com.fjbg.todo.data.repository.task

import com.fjbg.todo.data.local.TaskDatabase
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.data.repository.mapper.taskEntitiesToModels
import com.fjbg.todo.data.repository.mapper.taskEntityToModel
import com.fjbg.todo.data.repository.mapper.taskModelToEntity
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

    override suspend fun createTask(task: Task) =
        database.taskDao().createTask(taskModelToEntity(task))


    override suspend fun getTaskById(taskId: Int): Flow<Task?> {
        return database.taskDao().getTaskById(taskId).map { entity ->
            entity?.let {
                taskEntityToModel(it)
            }
        }
    }

    override suspend fun editTask(taskId: Int) {
    }

    override suspend fun deleteTask(taskId: Int) {
    }
}