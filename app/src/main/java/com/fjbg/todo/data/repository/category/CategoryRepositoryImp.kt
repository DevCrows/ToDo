package com.fjbg.todo.data.repository.category

import com.fjbg.todo.data.local.TaskDatabase
import com.fjbg.todo.data.local.model.Category
import com.fjbg.todo.data.repository.mapper.categoryEntitiesToModels
import com.fjbg.todo.data.repository.mapper.categoryModelToEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryRepositoryImp @Inject constructor(
    private val database: TaskDatabase
) : CategoryRepository {
    override suspend fun getCategories(): Flow<List<Category>?> {
        return database.categoryDao().getCategories().map { list ->
            list?.let {
                categoryEntitiesToModels(it)
            }
        }
    }

    override suspend fun addCategory(category: Category) {
        database.categoryDao().addCategory(categoryModelToEntity(category))
    }

    override suspend fun deleteCategory(categoryId: Int) {
        database.categoryDao().deleteCategory(categoryId)
    }
}