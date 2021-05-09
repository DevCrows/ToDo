package com.fjbg.todo.data.repository.category

import com.fjbg.todo.data.local.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories(): Flow<List<Category>?>
    suspend fun addCategory(category: Category)
    suspend fun deleteCategory(categoryId: Int)
}