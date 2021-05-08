package com.fjbg.todo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fjbg.todo.data.local.db.CategoryDao
import com.fjbg.todo.data.local.db.CategoryEntity
import com.fjbg.todo.data.local.db.TaskDao
import com.fjbg.todo.data.local.db.TaskEntity

@Database(
    entities = [
        TaskEntity::class,
        CategoryEntity::class],
    version = 1
)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun categoryDao(): CategoryDao
}