package com.fjbg.todo.data.local.model

data class Task(
    val id: Int,
    val title: String,
    val content: String? = "",
    val isActive: Boolean = true,
    val dateCreated: String?,
    val dateEdited: String?,
    val dateCompleted: String?,
    val dateDeleted: String?,
)