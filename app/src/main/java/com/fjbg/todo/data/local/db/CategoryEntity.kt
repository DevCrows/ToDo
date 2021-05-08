package com.fjbg.todo.data.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val color: String,
)