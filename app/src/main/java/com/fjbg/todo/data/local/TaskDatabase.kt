package com.fjbg.todo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fjbg.todo.data.local.db.*

@TypeConverters(Converter::class)
@Database(
    entities = [
        TaskEntity::class,
        CategoryEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun categoryDao(): CategoryDao
}