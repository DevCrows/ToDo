package com.fjbg.todo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fjbg.todo.data.local.db.TaskDao
import com.fjbg.todo.data.local.db.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}