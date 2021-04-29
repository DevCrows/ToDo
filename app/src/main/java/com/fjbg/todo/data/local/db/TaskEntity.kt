package com.fjbg.todo.data.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val content: String? = "",
    val isActive: Boolean = true,
    val dateCreated: String?,
    val dateEdited: String?,
    val dateCompleted: String?,
    val dateDeleted: String?,
)