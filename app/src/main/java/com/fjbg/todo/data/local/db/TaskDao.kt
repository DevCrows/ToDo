package com.fjbg.todo.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task WHERE isActive=1")
    fun getActiveTaskLit(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend

    fun addTask(task: TaskEntity)

    @Query("DELETE FROM task WHERE id=:taskId")
    suspend fun deleteTask(taskId: Int)
}