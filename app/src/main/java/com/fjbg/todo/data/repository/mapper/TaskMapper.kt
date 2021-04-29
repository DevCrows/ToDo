package com.fjbg.todo.data.repository.mapper

import com.fjbg.todo.data.local.db.TaskEntity
import com.fjbg.todo.data.local.model.Task


fun modelToEntity(task: Task): TaskEntity = TaskEntity(
    id = task.id,
    title = task.title,
    content = task.content,
    dateCreated = task.dateCreated,
    dateEdited = task.dateEdited,
    dateCompleted = task.dateCompleted,
    dateDeleted = task.dateDeleted,
    isActive = task.isActive,
)

fun entityToModel(entity: TaskEntity): Task = Task(
    id = entity.id,
    title = entity.title,
    content = entity.content,
    dateCreated = entity.dateCreated,
    dateEdited = entity.dateEdited,
    dateCompleted = entity.dateCompleted,
    dateDeleted = entity.dateDeleted,
    isActive = entity.isActive,
)

fun taskEntitiesToModels(entities: List<TaskEntity>): List<Task> {
    return entities.map(::entityToModel)
}