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

    @Query("SELECT * FROM category WHERE id=:categoryId")
    suspend fun getCategoryById(categoryId: Int): CategoryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCategory(category: CategoryEntity): Long?

    @Query("DELETE FROM category WHERE id=:categoryId")
    suspend fun deleteCategory(categoryId: Int)
}