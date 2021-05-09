package com.fjbg.todo.data.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val content: String? = "",
    val isActive: Boolean = true,
    val isImportant: Boolean = false,
    val dateCreated: Long?,
    val dateEdited: Long?,
    val dateCompleted: Long?,
    val dateDeleted: Long?,
    val categories: List<CategoryEntity>?,
)