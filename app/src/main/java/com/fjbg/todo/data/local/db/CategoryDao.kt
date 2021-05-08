package com.fjbg.todo.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getCategories(): Flow<List<CategoryEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCategory(category: CategoryEntity)

    @Query("DELETE FROM category WHERE name=:name")
    suspend fun deleteCategory(name: String)
}