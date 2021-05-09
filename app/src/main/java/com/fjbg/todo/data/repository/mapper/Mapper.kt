package com.fjbg.todo.data.repository.mapper

import com.fjbg.todo.data.local.db.CategoryEntity
import com.fjbg.todo.data.local.db.TaskEntity
import com.fjbg.todo.data.local.model.Category
import com.fjbg.todo.data.local.model.Task

fun taskModelToEntity(task: Task): TaskEntity = TaskEntity(
    id = task.id,
    title = task.title,
    content = task.content,
    dateCreated = task.dateCreated,
    dateEdited = task.dateEdited,
    dateCompleted = task.dateCompleted,
    dateDeleted = task.dateDeleted,
    isActive = task.isActive,
    isImportant = task.isImportant,
    categories = task.categories?.let(::categoriesModelsToEntities)
)

fun taskEntityToModel(entity: TaskEntity): Task = Task(
    id = entity.id,
    title = entity.title,
    content = entity.content,
    dateCreated = entity.dateCreated,
    dateEdited = entity.dateEdited,
    dateCompleted = entity.dateCompleted,
    dateDeleted = entity.dateDeleted,
    isActive = entity.isActive,
    isImportant = entity.isImportant,
    categories = entity.categories?.let(::categoryEntitiesToModels)
)

fun taskEntitiesToModels(entities: List<TaskEntity>): List<Task> =
    entities.map(::taskEntityToModel)

fun categoryEntityToModel(entity: CategoryEntity): Category = Category(
    id = entity.id,
    name = entity.name,
    color = entity.color,
)

fun categoryModelToEntity(category: Category): CategoryEntity = CategoryEntity(
    id = category.id,
    name = category.name,
    color = category.color,
)

fun categoryEntitiesToModels(entities: List<CategoryEntity>): List<Category> =
    entities.map(::categoryEntityToModel)

fun categoriesModelsToEntities(categories: List<Category>): List<CategoryEntity> =
    categories.map(::categoryModelToEntity)
