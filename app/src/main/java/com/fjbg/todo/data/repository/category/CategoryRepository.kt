package com.fjbg.todo.data.repository.category

import com.fjbg.todo.data.local.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories(): Flow<List<Category>?>
    suspend fun getCategoryById(categoryId: Int): Category
    suspend fun addCategory(category: Category): Boolean
    suspend fun deleteCategory(categoryId: Int)
}