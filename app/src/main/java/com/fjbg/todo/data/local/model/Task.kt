package com.fjbg.todo.data.local.model

data class Task(
    val id: Int,
    val title: String,
    val content: String? = "",
    val isActive: Boolean = true,
    val isImportant: Boolean = false,
    val dateCreated: Long? = null,
    val dateEdited: Long? = null,
    val dateCompleted: Long? = null,
    val dateDeleted: Long? = null,
    val categories: List<Category>?,
)

data class Category(
    val id: Int,
    val name: String,
    val color: String,
)